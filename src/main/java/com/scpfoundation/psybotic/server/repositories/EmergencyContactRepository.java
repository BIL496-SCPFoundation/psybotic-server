package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.EmergencyContact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyContactRepository extends MongoRepository<EmergencyContact,String> {
    List<EmergencyContact> findBySuperId(String userId);
}
