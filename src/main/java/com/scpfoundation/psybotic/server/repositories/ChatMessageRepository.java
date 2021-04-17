package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    @Query("{receiverId :?0} ")
    List<ChatMessage> findBySenderId(String receiverId);
}
