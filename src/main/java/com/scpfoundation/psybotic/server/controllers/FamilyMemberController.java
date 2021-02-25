package com.scpfoundation.psybotic.server.controllers;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.serviceInterfaces.IFamilyMemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/familyMembers")
public class FamilyMemberController {

    private final IFamilyMemberService familyMemberService;

    public FamilyMemberController(IFamilyMemberService familyMemberService){this.familyMemberService = familyMemberService;}


    @PostMapping("/insert")
    public GeneralResponse insert(@RequestBody FamilyMemberUser familyMemberUser) {
        return familyMemberService.insert(familyMemberUser);
    }

    @GetMapping("/findById")
    public FamilyMemberUser findById(@RequestParam("id") String id) {
        return familyMemberService.findById(id);
    }
}
