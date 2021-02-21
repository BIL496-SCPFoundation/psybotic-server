package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/insert")
    public GeneralResponse insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/findById")
    public User findById(@RequestParam("id") String id) {
        return userService.findById(id);
    }
}
