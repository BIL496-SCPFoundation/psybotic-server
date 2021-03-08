package com.scpfoundation.psybotic.server.firebase.firestore.repository;

import com.google.cloud.firestore.Firestore;
import com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData;

public class MessageRepo extends AbstractFirestoreRepository<MessageData> {
    public MessageRepo(Firestore firestore) {
        super(firestore, "messages");
    }
}
