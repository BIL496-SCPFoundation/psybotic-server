package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends MongoRepository<User, String> {
}
