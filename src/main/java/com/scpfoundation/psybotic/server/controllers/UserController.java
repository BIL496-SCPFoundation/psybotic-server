package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.*;

import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
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

    @GetMapping("/findByNearLocation")
    public List<User> findByNearLocation(@RequestParam("city") String city,@RequestParam("latitude") double latitude,@RequestParam("longitude") double longitude) {
        return userService.findByNearLocations(city,latitude,longitude);
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

    @GetMapping("/notifications")
    public List<Notification> findNotifications(@RequestParam("userId") String userId) {
        return userService.findNotifications(userId);
    }

    @PostMapping("/updateDeviceToken")
    public ResponseEntity<GeneralResponse> updateDeviceToken(@RequestBody User user) {
        return userService.updateDeviceToken(user);
    }
}
