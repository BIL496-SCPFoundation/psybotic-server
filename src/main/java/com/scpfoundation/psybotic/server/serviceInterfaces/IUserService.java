package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService extends ICRUDService<User, String> {
    User login(User user);

    List<EmergencyContact> findEmergencyContacts(String userId);

    List<FamilyMemberUser> findFamilyMembers(String userId);

    List<MentalState> findMentalStates(String userId);

    ResponseEntity<GeneralResponse> updateDeviceToken(User user);
}
