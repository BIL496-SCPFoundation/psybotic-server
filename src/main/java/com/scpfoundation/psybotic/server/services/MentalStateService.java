package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.MentalStateRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IMentalStateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentalStateService implements IMentalStateService {

    private final MentalStateRepository mentalStateRepository;

    public MentalStateService(MentalStateRepository mentalStateRepository) {
        this.mentalStateRepository = mentalStateRepository;
    }


    @Override
    public GeneralResponse insert(MentalState mentalState) {
        GeneralResponse res = new GeneralResponse();
        try {
            mentalStateRepository.save(mentalState);
            res.setMessage("User saved successfully");
            res.setStatus(200);
        } catch (Exception e) {
            res.setError(e.getMessage());
            res.setMessage("Encountered an error while saving user");
            res.setStatus(500); // 500: internal server error
        }
        return res;
    }

    @Override
    public MentalState findById(String id) {

        Optional<MentalState> optionalUser = mentalStateRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
