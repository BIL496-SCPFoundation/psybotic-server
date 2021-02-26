package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.MentalStateRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IMentalStateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentalStateService
        extends CRUDService<MentalStateRepository, MentalState>
        implements IMentalStateService {

    private final MentalStateRepository mentalStateRepository;

    public MentalStateService(MentalStateRepository mentalStateRepository) {
        super(mentalStateRepository);
        this.mentalStateRepository = mentalStateRepository;
    }
}
