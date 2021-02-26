package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.serviceInterfaces.IMentalStateService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentalStates")
public class MentalStateController {

    private final IMentalStateService mentalStateService;

    public MentalStateController(IMentalStateService mentalStateService){ this.mentalStateService =mentalStateService;}


    @PostMapping("/insert")
        public ResponseEntity<GeneralResponse> insert(@RequestBody MentalState mentalState) {
        return mentalStateService.insert(mentalState);
    }

    @GetMapping("/findById")
    public MentalState findById(@RequestParam("id") String id) {
        return mentalStateService.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@RequestBody MentalState mentalState) {
        return mentalStateService.update(mentalState);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return mentalStateService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> deleteById(@RequestBody MentalState mentalState) {
        return mentalStateService.delete(mentalState);
    }
}
