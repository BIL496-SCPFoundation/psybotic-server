package com.scpfoundation.psybotic.server.firebase.fcm.service;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
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

@Service
public class FirebaseMessageService {


    private final Logger logger = LoggerFactory.getLogger(FirebaseMessageService.class);
    private final FCMService fcmService;
    private final IUserService userService;
    private final IFirestoreService firestoreService;

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
        MessageData pushData = new MessageData();
        return pushData;
    }

    public ResponseEntity<GeneralResponse> sendMessage(FirebaseMessageRequest request) {
        GeneralResponse res = new GeneralResponse();
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
            } else if (receiver != null) {
                data.setSenderFirstName(sender.getFirstName());
                data.setSenderLastName(sender.getLastName());
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
            }
        } catch (Exception e) {
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
}
