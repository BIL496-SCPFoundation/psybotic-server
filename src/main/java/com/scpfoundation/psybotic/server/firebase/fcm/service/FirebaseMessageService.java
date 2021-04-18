package com.scpfoundation.psybotic.server.firebase.fcm.service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.database.annotations.Nullable;
import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.MessageResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.AIMessage;
import com.scpfoundation.psybotic.server.firebase.fcm.model.AIResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData;
import com.scpfoundation.psybotic.server.firebase.fcm.model.FirebaseMessageRequest;
import com.scpfoundation.psybotic.server.firebase.firestore.annotation.DocumentId;
import com.scpfoundation.psybotic.server.firebase.firestore.service.IFirestoreService;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.IChatMessageService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseMessageService {


    private final Logger logger = LoggerFactory.getLogger(FirebaseMessageService.class);
    private final FCMService fcmService;
    private final IUserService userService;
    private final IFirestoreService firestoreService;
    private RestTemplate rest = new RestTemplate();
    private final String AI_HOST = "https://psyboticrasa.herokuapp.com";
    private final Firestore firestore;
    private final IChatMessageService chatMessageService;

    public FirebaseMessageService(FCMService fcmService, IUserService userService, IFirestoreService firestoreService, Firestore firestore, IChatMessageService chatMessageService) {
        this.fcmService = fcmService;
        this.userService = userService;
        this.firestoreService = firestoreService;
        this.firestore = firestore;
        this.chatMessageService = chatMessageService;
    }


    public void sendPushNotification(FirebaseMessageRequest request) {
        try {
            fcmService.sendMessage(getSamplePayloadData(), request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void sendPushNotificationWithoutData(FirebaseMessageRequest request) {
        try {
            fcmService.sendMessageWithoutData(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    public void sendPushNotificationToToken(FirebaseMessageRequest request) {
        try {
            fcmService.sendMessageToToken(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    private MessageData getSamplePayloadData() {
        return new MessageData();
    }

    public ResponseEntity<MessageResponse> sendMessage(FirebaseMessageRequest request) {
        MessageResponse res = new MessageResponse();
        try {
            MessageData data = request.getData();
            boolean receiverIsChatbot = data.getReceiverId().equals("chatbot");
            User receiver = userService.findById(data.getReceiverId());
            User sender = userService.findById(data.getSenderId());
            if (receiver == null && !receiverIsChatbot) {
                res.setMessage("Message not sent");
                res.setWarning("Receiver not found");
            } else if (sender == null) {
                res.setMessage("Message not sent");
                res.setWarning("Sender not found");
            } else {
                data.setSenderFirstName(sender.getFirstName());
                data.setSenderLastName(sender.getLastName());
                if (receiverIsChatbot) {
                    sendMessageToChatbot(request, res, data, sender);
                } else {
                    sendMessageToUser(request, res, data, receiver, sender);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            res.setMessage("Internal server error");
            res.setError(e.getMessage());
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        HttpStatus status = HttpStatus.resolve(res.getStatus());
        if (status != null) {
            return new ResponseEntity<>(res, status);
        } else {
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendMessageToChatbot(FirebaseMessageRequest request, MessageResponse res, MessageData data, User sender) {
        String aiMessagePost = AI_HOST + "/webhooks/rest/webhook";
        AIMessage message = new AIMessage();
        message.setMessage(data.getMessage());
        message.setSender(data.getSenderId());
        ResponseEntity<AIResponse[]> aiResponse = rest.postForEntity(aiMessagePost, message, AIResponse[].class);
        if (Objects.requireNonNull(aiResponse.getBody()).length == 0) {
            res.setChatbotResponse(new AIResponse(data.getSenderId()));
            res.setWarning("Chatbot could not produce a proper response for this conversation");
        } else {
            res.setChatbotResponse(aiResponse.getBody()[0]);
        }
        firestore.collection("chats/chatbot/" + data.getChatRoomId()).document().set(data);
        MessageData resMessage = new MessageData();
        sendResponseMessage(res, data, resMessage);
//        if (sender.getDeviceToken() != null) {
//            //send response message to the user's device
//            request.setData(resMessage);
//            request.setToken(sender.getDeviceToken());
//            request.setTitle("Psybotic");
//            sendPushNotificationToToken(request);
//        }
        chatMessageService.insert(new ChatMessage(data));
        chatMessageService.insert(new ChatMessage(resMessage));
        res.setStatus(HttpStatus.OK.value());
        res.setMessage("Message sent successfully to the chatbot.");
        logger.info("Message sent to the psybotic and got a response");
    }

    private void sendResponseMessage(MessageResponse res, MessageData data, MessageData resMessage) {
        resMessage.setChatRoomId(data.getChatRoomId());
        resMessage.setReceiverId(data.getSenderId());
        resMessage.setMessage(res.getChatbotResponse().getText());
        resMessage.setSenderFirstName("Psybotic");
        resMessage.setSenderId("chatbot");
        firestore.collection("chats/chatbot/" + data.getChatRoomId()).document().set(resMessage);
    }

    private void sendMessageToUser(FirebaseMessageRequest request, GeneralResponse res, MessageData data,
                                   User receiver, User sender) throws InterruptedException, ExecutionException {
        request.setTitle(sender.getFirstName());
        request.setMessage(data.getMessage());
        if (receiver.getDeviceToken() != null) {
            request.setToken(receiver.getDeviceToken());
        } else {
            res.setWarning("Receiver device token is empty. Therefore, the message or notification cannot be " +
                    "sent to the android device that the receiver using, if s/he is using one.");
        }
        firestore.collection("chats/psychologist/" + data.getChatRoomId()).document().set(data);
        chatMessageService.insert(new ChatMessage(data));
        sendPushNotificationToToken(request);
        res.setStatus(HttpStatus.OK.value());
        res.setMessage("Message sent successfully");
        logger.info("Message sent to a real user");
    }

    private String getDocumentId(MessageData data) {
        Object key;
        Class clzz = data.getClass();
        do {
            key = getKeyFromFields(clzz, data);
            clzz = clzz.getSuperclass();
        } while (key == null && clzz != null);

        if (key == null) {
            return UUID.randomUUID().toString();
        }
        return String.valueOf(key);

    }

    private Object getKeyFromFields(Class<?> clazz, Object t) {

        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(DocumentId.class))
                .findFirst()
                .map(field -> getValue(t, field))
                .orElse(null);
    }

    @Nullable
    private Object getValue(Object t, java.lang.reflect.Field field) {
        field.setAccessible(true);
        try {
            return field.get(t);
        } catch (IllegalAccessException e) {
            logger.error("Error in getting documentId key", e);
        }
        return null;
    }

}
