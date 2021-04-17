package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.MentalState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface MentalStateRepository extends MongoRepository<MentalState,String> {
    List<MentalState> findBySuperId(String userId);
}
