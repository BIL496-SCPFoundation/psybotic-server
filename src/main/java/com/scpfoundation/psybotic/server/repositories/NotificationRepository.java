package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.Notification;
import com.scpfoundation.psybotic.server.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification,String> {
    List<Notification> findByUserId(String UserId);

    @Query("{'city :?0, " + "longitude :?0," + "latitude :?0 } ")
    List<User> findByNearLocations(String city, double latitude, double longitude);
}
