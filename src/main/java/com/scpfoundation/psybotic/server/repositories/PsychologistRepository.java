package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.Psychologist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface PsychologistRepository extends MongoRepository<Psychologist,String> {
    List<Psychologist> findAllByApprovedIsNot(boolean approved);

    List<Psychologist> findAlByApprovedIs(boolean approved);
}
