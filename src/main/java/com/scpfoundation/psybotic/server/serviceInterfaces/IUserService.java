package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService extends ICRUDService<User, String> {
    User login(User user);

    List<EmergencyContact> findEmergencyContacts(String userId);

    List<FamilyMemberUser> findFamilyMembers(String userId);

    List<MentalState> findMentalStates(String userId);

    List<Notification> findNotifications(String userId);

    List<User> findByNearLocations(String city, double latitude, double longitude);

    ResponseEntity<GeneralResponse> updateDeviceToken(User user);
}
