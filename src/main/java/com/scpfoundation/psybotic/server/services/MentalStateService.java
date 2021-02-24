package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.repositories.MentalStateRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IMentalStateService;

public class MentalStateService implements IMentalStateService {

    private final MentalStateRepository mentalStateRepository;

    public MentalStateService(MentalStateRepository mentalStateRepository) {
        this.mentalStateRepository = mentalStateRepository;
    }


    @Override
    public GeneralResponse insert(MentalState mentalState) {
        return null;
    }

    @Override
    public MentalState findById(String id) {
        return null;
    }
}
