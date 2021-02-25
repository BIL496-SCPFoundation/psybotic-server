package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.Psyhchologist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsyhchologistRepository extends MongoRepository<Psyhchologist,String> {
}
