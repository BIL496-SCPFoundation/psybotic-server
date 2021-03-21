package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.Psychologist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface PsychologistRepository extends MongoRepository<Psychologist,String> {
}
