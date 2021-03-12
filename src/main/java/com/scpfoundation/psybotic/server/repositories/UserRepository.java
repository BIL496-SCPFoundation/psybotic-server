package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByGoogleId(String googleId);
    List<User> findUserByNearly(String location,double longitude,double latitude);

}
