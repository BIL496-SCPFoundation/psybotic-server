package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.FamilyMemberRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IFamilyMemberService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyMemberService
        extends CRUDService<FamilyMemberRepository, FamilyMemberUser>
        implements IFamilyMemberService {

    private final FamilyMemberRepository familyMemberRepository;

    public FamilyMemberService(FamilyMemberRepository familyMemberRepository) {
        super(familyMemberRepository);
        this.familyMemberRepository = familyMemberRepository;

    }
}
