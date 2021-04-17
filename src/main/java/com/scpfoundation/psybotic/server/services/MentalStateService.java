package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.firebase.fcm.model.FirebaseMessageRequest;
import com.scpfoundation.psybotic.server.firebase.fcm.service.FirebaseMessageService;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.Notification;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.MentalStateRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IMentalStateService;
import com.scpfoundation.psybotic.server.serviceInterfaces.INotificationService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentalStateService
        extends CRUDService<MentalStateRepository, MentalState>
        implements IMentalStateService {

    private final MentalStateRepository mentalStateRepository;
    private final IUserService userService;
    private final FirebaseMessageService firebaseMessageService;
    private final INotificationService notificationService;
    public MentalStateService(MentalStateRepository mentalStateRepository, IUserService userService, FirebaseMessageService firebaseMessageService, INotificationService notificationService) {
        super(mentalStateRepository);
        this.mentalStateRepository = mentalStateRepository;
        this.userService = userService;
        this.firebaseMessageService = firebaseMessageService;
        this.notificationService = notificationService;
    }

    private final String TEST_URL = "https://psybotic.herokuapp.com/mentalState/test";

    @Scheduled(fixedRate = 3_600_000 * 24 * 7)
    private void remindTest() {
        List<User> users = userService.findAll();
        for (User user :
                users) {
            FirebaseMessageRequest req = new FirebaseMessageRequest();
            if (user.getDeviceToken() != null && !user.getDeviceToken().equals("")) {
                req.setTitle("Weekly reminder");
                req.setToken(user.getDeviceToken());
                req.setMessage("Hello " + user.getFirstName() + ", we care about you. Could you please inform us " +
                        "about your mentality by submiting this test: " + TEST_URL + "\n Thank you :)");
                firebaseMessageService.sendPushNotificationToToken(req);
            }
        }
    }

}
