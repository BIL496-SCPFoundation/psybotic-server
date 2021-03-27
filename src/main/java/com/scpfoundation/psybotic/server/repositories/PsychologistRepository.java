package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.Psychologist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface PsychologistRepository extends MongoRepository<Psychologist,String> {
    @Query("{$and: [{approved: false}, {rejected: false}]}")
    List<Psychologist> findAllApplicants();

    @Query("{$and: [{approved: true}, {rejected: false}]}")
    List<Psychologist> findAllVerifiedPsychologists();

    @Query("{$or: [{approved: true}, {rejected: true}]}")
    List<Psychologist> findAllOldApplicants();

}
