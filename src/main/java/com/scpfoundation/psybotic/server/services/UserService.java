package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.EmergencyContactRepository;
import com.scpfoundation.psybotic.server.repositories.FamilyMemberRepository;
import com.scpfoundation.psybotic.server.repositories.MentalStateRepository;
import com.scpfoundation.psybotic.server.repositories.UserRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService extends CRUDService<UserRepository, User> implements IUserService{

    private final UserRepository userRepository;
    private final EmergencyContactRepository emergencyContactRepository;
    private final FamilyMemberRepository familyMemberRepository;
    private final MentalStateRepository mentalStateRepository;

    public UserService(UserRepository userRepository, EmergencyContactRepository emergencyContactRepository, FamilyMemberRepository familyMemberRepository, MentalStateRepository mentalStateRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.emergencyContactRepository = emergencyContactRepository;
        this.familyMemberRepository = familyMemberRepository;
        this.mentalStateRepository = mentalStateRepository;
    }

    @Override
    @Transactional
    public User login(User user) {
        /*
        googleId and id are the same
         */
        user.setId(user.getGoogleId());
        userRepository.save(user);
        return user;
    }

    @Override
    public List<EmergencyContact> findEmergencyContacts(String userId) {
        return emergencyContactRepository.findBySuperId(userId);
    }

    @Override
    public List<FamilyMemberUser> findFamilyMembers(String userId) {
        return familyMemberRepository.findBySuperId(userId);
    }

    @Override
    public List<MentalState> findMentalStates(String userId) {
        return mentalStateRepository.findBySuperId(userId);
    }
}
