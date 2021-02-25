package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.FamilyMemberRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IFamilyMemberService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyMemberService implements IFamilyMemberService {

    private final FamilyMemberRepository familyMemberRepository;

    public FamilyMemberService(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;

    }

    @Override
    public GeneralResponse insert(FamilyMemberUser familyMemberUser) {
        GeneralResponse res = new GeneralResponse();
        try {
            familyMemberRepository.save(familyMemberUser);
            res.setMessage("Family Member User saved successfully");
            res.setStatus(200);
        } catch (Exception e) {
            res.setError(e.getMessage());
            res.setMessage("Encountered an error while saving familyMemberUser");
            res.setStatus(500); // 500: internal server error
        }
        return res;


    }

    @Override
    public FamilyMemberUser findById(String id) {
        Optional<FamilyMemberUser> optionalUser = familyMemberRepository.findById(id);
        return optionalUser.orElse(null);

    }
}
