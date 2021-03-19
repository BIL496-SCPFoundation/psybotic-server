package com.scpfoundation.psybotic.server.firebase.firestore.service;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData;
import org.springframework.http.ResponseEntity;

public interface IFirestoreService {
    ResponseEntity<GeneralResponse> save(MessageData messageData);
}
