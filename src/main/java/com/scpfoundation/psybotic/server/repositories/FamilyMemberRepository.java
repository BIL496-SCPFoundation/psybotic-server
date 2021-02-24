package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends MongoRepository<FamilyMemberUser,String> {
}
