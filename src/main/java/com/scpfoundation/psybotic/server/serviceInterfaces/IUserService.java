package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.User;
import org.springframework.http.ResponseEntity;

public interface IUserService extends ICRUDService<User, String> {
    User login(User user);
}
