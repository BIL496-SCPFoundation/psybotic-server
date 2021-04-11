package com.scpfoundation.psybotic.server.firebase.fcm;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.FirebaseMessageRequest;
import com.scpfoundation.psybotic.server.firebase.fcm.model.FirebaseMessageResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.service.FirebaseMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firebase")
public class FirebaseMessageController {

    private FirebaseMessageService firebaseMessageService;

    public FirebaseMessageController(FirebaseMessageService firebaseMessageService) {
        this.firebaseMessageService = firebaseMessageService;
    }

    @PostMapping("/topic")
    public ResponseEntity sendNotification(@RequestBody FirebaseMessageRequest request) {
        firebaseMessageService.sendPushNotificationWithoutData(request);
        return new ResponseEntity<>(new FirebaseMessageResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping("/token")
    public ResponseEntity sendTokenNotification(@RequestBody FirebaseMessageRequest request) {
        firebaseMessageService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new FirebaseMessageResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity sendDataNotification(@RequestBody FirebaseMessageRequest request) {
        firebaseMessageService.sendPushNotification(request);
        return new ResponseEntity<>(new FirebaseMessageResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity sendNotificationToUser(@RequestBody FirebaseMessageRequest request) {
//        pushNotificationService.sendPushToUser(request);
        return new ResponseEntity<>(new FirebaseMessageResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<GeneralResponse> sendMessage(@RequestBody FirebaseMessageRequest request) {
        return firebaseMessageService.sendMessage(request);
    }
}
