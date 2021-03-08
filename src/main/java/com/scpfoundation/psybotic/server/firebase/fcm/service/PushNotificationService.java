package com.scpfoundation.psybotic.server.firebase.fcm.service;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData;
import com.scpfoundation.psybotic.server.firebase.fcm.model.PushNotificationRequest;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

//    @Value("#{${app.notifications.defaults}}")
//    private Map<String, String> defaults;

    private final Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
    private final FCMService fcmService;
    private final IUserService userService;

    public PushNotificationService(FCMService fcmService, IUserService userService) {
        this.fcmService = fcmService;
        this.userService = userService;
    }



    public void sendPushNotification(PushNotificationRequest request) {
        try {
            fcmService.sendMessage(getSamplePayloadData(), request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void sendPushNotificationWithoutData(PushNotificationRequest request) {
        try {
            fcmService.sendMessageWithoutData(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    public void sendPushNotificationToToken(PushNotificationRequest request) {
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

    public ResponseEntity<GeneralResponse> sendMessage(PushNotificationRequest request) {
        GeneralResponse res = new GeneralResponse();
        try {
            MessageData data = request.getData();
            User receiver = userService.findById(data.getReceiverId());
            User sender = userService.findById(data.getSenderId());
            if (receiver == null) {
                res.setMessage("Message not sent");
                res.setWarning("Receiver not found");
            } else if (sender == null) {
                res.setMessage("Message not sent");
                res.setWarning("Sender not found");
            } else {
                data.setSenderFirstName(sender.getFirstName());
                data.setSenderLastName(sender.getLastName());
                request.setTitle(receiver.getFirstName());
                request.setMessage(data.getMessage());
                request.setToken(receiver.getDeviceToken());
                fcmService.sendMessage(data, request);
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

//    public void sendPushToUser(PushNotificationRequest request) {
//        try {
//            fcmService.sendMessageToUser(request);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//
//    }


//    private PushNotificationRequest getSamplePushNotificationRequest() {
//        PushNotificationRequest request = new PushNotificationRequest(defaults.get("title"),
//                defaults.get("message"),
//                defaults.get("topic"));
//        return request;
//    }


}
