package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.serviceInterfaces.IEmergencyContactService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emergency_contacts")
public class EmergencyContactController {
    private final IEmergencyContactService emergencyContactService;

    public EmergencyContactController(IEmergencyContactService emergencyContactService) {
        this.emergencyContactService = emergencyContactService;
    }

    @PostMapping("/insert")
    public GeneralResponse insert(@RequestBody EmergencyContact emergencyContact) {
        return emergencyContactService.insert(emergencyContact);
    }

    @GetMapping("/findById")
    public EmergencyContact findById(@RequestParam("id") String id) {
        return emergencyContactService.findById(id);
    }
}
