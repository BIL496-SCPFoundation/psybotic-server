package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.serviceInterfaces.IFamilyMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/familyMembers")
@CrossOrigin("*")
public class FamilyMemberController {

    private final IFamilyMemberService familyMemberService;

    public FamilyMemberController(IFamilyMemberService familyMemberService){this.familyMemberService = familyMemberService;}


    @PostMapping("/insert")
    public ResponseEntity<GeneralResponse> insert(@RequestBody FamilyMemberUser familyMemberUser) {
        return familyMemberService.insert(familyMemberUser);
    }

    @GetMapping("/findById")
    public FamilyMemberUser findById(@RequestParam("id") String id) {
        return familyMemberService.findById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<GeneralResponse> update(@RequestBody FamilyMemberUser familyMemberUser) {
        return familyMemberService.update(familyMemberUser);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<GeneralResponse> deleteById(@RequestParam("id") String id) {
        return familyMemberService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GeneralResponse> deleteById(@RequestBody FamilyMemberUser familyMemberUser) {
        return familyMemberService.delete(familyMemberUser);
    }
}
