package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.MentalState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentalStateRepository extends MongoRepository<MentalState,String> {
}
