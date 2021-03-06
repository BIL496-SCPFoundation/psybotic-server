package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.serviceInterfaces.IEmergencyContactService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/emergencyContacts")
@CrossOrigin("*")
public class EmergencyContactController {
    private final IEmergencyContactService emergencyContactService;

    public EmergencyContactController(IEmergencyContactService emergencyContactService) {
        this.emergencyContactService = emergencyContactService;
    }

    @PostMapping("/insert")
    public ResponseEntity<GeneralResponse> insert(@RequestBody EmergencyContact emergencyContact) {
        return emergencyContactService.insert(emergencyContact);
    }

    @GetMapping("/findById")
    public EmergencyContact findById(@RequestParam("id") String id) {
        return emergencyContactService.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@RequestBody EmergencyContact emergencyContact) {
        return emergencyContactService.update(emergencyContact);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return emergencyContactService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> deleteById(@RequestBody EmergencyContact emergencyContact) {
        return emergencyContactService.delete(emergencyContact);
    }
}
