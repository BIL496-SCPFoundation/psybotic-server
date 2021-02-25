package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.EmergencyContactRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IEmergencyContactService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmergencyContactService implements IEmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;

    public EmergencyContactService(EmergencyContactRepository emergencyContactRepository) {
        this.emergencyContactRepository = emergencyContactRepository;
    }

    @Override
    public GeneralResponse insert(EmergencyContact emergencyContact) {
        GeneralResponse res = new GeneralResponse();
        try {
            emergencyContactRepository.save(emergencyContact);
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
    public EmergencyContact findById(String id) {
        Optional<EmergencyContact> optionalUser = emergencyContactRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
