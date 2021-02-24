package com.scpfoundation.psybotic.server.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisasterRepository extends MongoRepository<DisasterRepository,String> {
}
