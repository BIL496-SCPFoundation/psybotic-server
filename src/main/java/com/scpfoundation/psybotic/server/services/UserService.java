package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.UserRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends CRUDService<UserRepository, User> implements IUserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User login(User user) {
        User tmpUser = userRepository.findUserByGoogleId(user.getGoogleId());
        if (tmpUser != null) {
            return tmpUser;
        } else {
            /*
            googleId and id are the same
             */
            user.setId(user.getGoogleId());
            userRepository.save(user);
            return user;
        }
    }
}
