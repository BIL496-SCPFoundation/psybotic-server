package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.EmergencyContactRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IEmergencyContactService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmergencyContactService
        extends CRUDService<EmergencyContactRepository, EmergencyContact>
        implements IEmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;

    public EmergencyContactService(EmergencyContactRepository emergencyContactRepository) {
        super(emergencyContactRepository);
        this.emergencyContactRepository = emergencyContactRepository;
    }
}
