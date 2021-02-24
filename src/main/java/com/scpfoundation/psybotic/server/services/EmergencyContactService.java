package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.repositories.EmergencyContactRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IEmergencyContactService;

public class EmergencyContactService implements IEmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;

    public EmergencyContactService(EmergencyContactRepository emergencyContactRepository) {
        this.emergencyContactRepository = emergencyContactRepository;
    }

    @Override
    public GeneralResponse insert(EmergencyContact emergencyContact) {
        return null;
    }

    @Override
    public EmergencyContact findById(String id) {
        return null;
    }
}
