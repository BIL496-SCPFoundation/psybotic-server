package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByGoogleId(String googleId);
    @Query(value = "{ location :\n" +
            "       { $near :\n" +
            "          {\n" +
            "            $geometry : {\n" +
            "               type : \"Point\" ,\n" +
            "               coordinates : [?1, ?2] },\n" +
            "            $maxDistance : 1\n" +
            "          }\n" +
            "       }\n" +
            "  }")
    List<User> findNearbyUsers(String location,double longitude,double latitude);

}
