package com.scpfoundation.psybotic.server.services;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.UserRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GeneralResponse insert(User user) {
        GeneralResponse res = new GeneralResponse();
        try {
            userRepository.save(user);
            res.setMessage("User saved successfully");
            res.setStatus(200);
        } catch (Exception e) {
            res.setError(e.getMessage());
            res.setMessage("Encountered an error while saving user");
            res.setStatus(500); // 500: internal server error
        }
        return res;
    }

    @Override
    public User findById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
