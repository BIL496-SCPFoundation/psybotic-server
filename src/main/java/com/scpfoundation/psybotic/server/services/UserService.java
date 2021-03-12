package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.models.*;
import com.scpfoundation.psybotic.server.repositories.*;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService extends CRUDService<UserRepository, User> implements IUserService{

    private final UserRepository userRepository;
    private final EmergencyContactRepository emergencyContactRepository;
    private final FamilyMemberRepository familyMemberRepository;
    private final MentalStateRepository mentalStateRepository;
    private final NotificationRepository notificationRepository;

    public UserService(UserRepository userRepository, NotificationRepository notificationRepository, EmergencyContactRepository emergencyContactRepository, FamilyMemberRepository familyMemberRepository, MentalStateRepository mentalStateRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.emergencyContactRepository = emergencyContactRepository;
        this.familyMemberRepository = familyMemberRepository;
        this.mentalStateRepository = mentalStateRepository;
        this.notificationRepository=notificationRepository;
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

    @Override
    public List<Notification> findNotifications(String userId) {
        return notificationRepository.findBySuperId(userId);
    }

    public List<User> findByNearLocations(String city, double latitude, double longitude) {
        return userRepository.findUserByNearly(city,latitude,longitude);
    }

}
