package com.scpfoundation.psybotic.server.firebase.firestore;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData;
import com.scpfoundation.psybotic.server.firebase.firestore.service.IFirestoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/firestore")
@CrossOrigin("*")
public class FirestoreController {

    private final IFirestoreService firestoreService;

    public FirestoreController(IFirestoreService firestoreService) {
        this.firestoreService = firestoreService;
    }

    @PostMapping("/save")
    public ResponseEntity<GeneralResponse> save(@RequestBody MessageData messageData) {
        return firestoreService.save(messageData);
    }
}
