package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.*;
import com.scpfoundation.psybotic.server.repositories.*;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<User> opt = userRepository.findById(user.getGoogleId());
        if (opt.isPresent()) {
            User tmp = opt.get();
            updateAfterLogin(user, tmp);
            return tmp;
        } else {
            user.setId(user.getGoogleId());
            userRepository.save(user);
            return user;
        }
    }

    private void updateAfterLogin(User user, User tmp) {
        if (user.getDeviceToken() != null && !user.getDeviceToken().equals("")) {
            tmp.setDeviceToken(user.getDeviceToken());
        }
        tmp.setImageUrl(user.getImageUrl());
        userRepository.save(tmp);
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
        return notificationRepository.findByUserId(userId);
    }

    public List<User> findByNearLocations(String city, double latitude, double longitude) {
        return userRepository.findNearbyUsers(city,latitude,longitude);
    }


    @Override
    @Transactional
    public ResponseEntity<GeneralResponse> updateDeviceToken(User user) {
        GeneralResponse res = new GeneralResponse();
        try {
            User origUser = findById(user.getId());
            if (origUser != null) {
                origUser.setDeviceToken(user.getDeviceToken());
                res.setMessage("Device token updated successfully");
                res.setStatus(HttpStatus.OK.value());
            } else {
                res.setMessage("Event not successful");
                res.setWarning("User not found by the provided id");
                res.setStatus(HttpStatus.OK.value());
            }
        } catch (Exception e) {
            res.setError(e.getMessage());
            res.setMessage("Internal server error");
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        HttpStatus status = HttpStatus.resolve(res.getStatus());
        if (status != null) {
            return new ResponseEntity<>(res, status);
        } else {
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
