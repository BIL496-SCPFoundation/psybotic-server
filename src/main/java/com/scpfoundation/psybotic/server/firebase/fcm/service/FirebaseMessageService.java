package com.scpfoundation.psybotic.server.firebase.fcm.service;

import com.google.gson.Gson;
import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.MessageResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.AIMessage;
import com.scpfoundation.psybotic.server.firebase.fcm.model.AIResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData;
import com.scpfoundation.psybotic.server.firebase.fcm.model.FirebaseMessageRequest;
import com.scpfoundation.psybotic.server.firebase.firestore.service.IFirestoreService;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseMessageService {


    private final Logger logger = LoggerFactory.getLogger(FirebaseMessageService.class);
    private final FCMService fcmService;
    private final IUserService userService;
    private final IFirestoreService firestoreService;
    private RestTemplate rest = new RestTemplate();
    private final String AI_HOST = "https://psyboticrasa.herokuapp.com";

    public FirebaseMessageService(FCMService fcmService, IUserService userService, IFirestoreService firestoreService) {
        this.fcmService = fcmService;
        this.userService = userService;
        this.firestoreService = firestoreService;
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
                    sendMessageToChatbot(request, res, data);
                } else {
                    sendMessageToUser(request, res, data, receiver);
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

    private void sendMessageToChatbot(FirebaseMessageRequest request, MessageResponse res, MessageData data) {
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
        firestoreService.save(data);
        res.setStatus(HttpStatus.OK.value());
        res.setMessage("Message sent successfully to the chatbot.");
        logger.info("Message sent to the psybotic and got a response");
    }

    private void sendMessageToUser(FirebaseMessageRequest request, GeneralResponse res, MessageData data,
                                   User receiver) throws InterruptedException, ExecutionException {
        request.setTitle(receiver.getFirstName());
        request.setMessage(data.getMessage());
        if (receiver.getDeviceToken() != null) {
            request.setToken(receiver.getDeviceToken());
        } else {
            res.setWarning("Receiver device token is empty. Therefore, the message or notification cannot be " +
                    "sent to the android device that the receiver using, if s/he is using one.");
        }
        fcmService.sendMessage(data, request);
        data.setChatRoomId(data.getSenderId() + data.getReceiverId());
        firestoreService.save(data);
        res.setStatus(HttpStatus.OK.value());
        res.setMessage("Message sent successfully");
        logger.info("Message sent to a real user");
    }
}
