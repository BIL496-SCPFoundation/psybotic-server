package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.repositories.FamilyMemberRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IFamilyMemberService;

public class FamilyMemberService implements IFamilyMemberService {

    private final FamilyMemberRepository familyMemberRepository;

    public FamilyMemberService(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    @Override
    public GeneralResponse insert(FamilyMemberUser familyMemberUser) {
        return null;
    }

    @Override
    public FamilyMemberUser findById(String id) {
        return null;
    }
}
