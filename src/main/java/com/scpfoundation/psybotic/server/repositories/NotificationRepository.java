package com.scpfoundation.psybotic.server.repositories;

import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.Notification;
import com.scpfoundation.psybotic.server.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface NotificationRepository extends MongoRepository<Notification,String> {
    List<Notification> findByUserId(String UserId);

    @Query("{'city :?0, " + "longitude :?0," + "latitude :?0 } ")
    List<User> findByNearLocations(String city, double latitude, double longitude);

    @Query("{reply: false,bildiri: false}")
    List<Notification> findByNotificationNoReplyed(Boolean reply,Boolean bildiri);

}
