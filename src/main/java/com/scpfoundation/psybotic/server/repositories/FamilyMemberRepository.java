package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface FamilyMemberRepository extends MongoRepository<FamilyMemberUser,String> {
    List<FamilyMemberUser> findBySuperId(String userId);
}
