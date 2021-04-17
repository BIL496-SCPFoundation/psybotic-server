package com.scpfoundation.psybotic.server.firebase.firestore.service;

import com.google.cloud.firestore.Firestore;
import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData;
import com.scpfoundation.psybotic.server.firebase.firestore.config.FirestoreConfig;
import com.scpfoundation.psybotic.server.firebase.firestore.repository.MessageRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FirestoreService implements IFirestoreService {

    private final MessageRepo messageRepo;
    private final Firestore firestore;

    public FirestoreService(FirestoreConfig firestoreConfig, Firestore firestore) {
        this.firestore = firestore;
        messageRepo = new MessageRepo(firestore);
    }

    @Override
    public ResponseEntity<GeneralResponse> save(MessageData messageData) {
        GeneralResponse res = new GeneralResponse();
        try {
            messageRepo.save(messageData);
            res.setMessage("Message saved successfully");
            res.setStatus(HttpStatus.OK.value());
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
