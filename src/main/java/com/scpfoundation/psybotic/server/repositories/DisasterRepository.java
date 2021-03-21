package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.Disaster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface DisasterRepository extends MongoRepository<Disaster,String> {
}
