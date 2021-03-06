package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.ICRUDService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/insert")
    public ResponseEntity<GeneralResponse> insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/findById")
    public User findById(@RequestParam("id") String id) {
        return userService.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@RequestBody User updatedUser) {
        return userService.update(updatedUser);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return userService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> delete(@RequestBody User user) {
        return userService.delete(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/emergencyContacts")
    public List<EmergencyContact> findEmergencyContacts(@RequestParam("userId") String userId) {
        return userService.findEmergencyContacts(userId);
    }

    @GetMapping("/familyMembers")
    public List<FamilyMemberUser> findFamilyMembers(@RequestParam("userId") String userId) {
        return userService.findFamilyMembers(userId);
    }

    @GetMapping("/mentalStates")
    public List<MentalState> findMentalStates(@RequestParam("userId") String userId) {
        return userService.findMentalStates(userId);
    }

}
