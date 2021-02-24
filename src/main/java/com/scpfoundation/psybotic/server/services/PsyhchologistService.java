package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psyhchologist;
import com.scpfoundation.psybotic.server.repositories.PsyhchologistRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IPsyhchologistService;

public class PsyhchologistService implements IPsyhchologistService {

    private final PsyhchologistRepository psyhchologistRepository;

    public PsyhchologistService(PsyhchologistRepository psyhchologistRepository) {
        this.psyhchologistRepository = psyhchologistRepository;
    }

    @Override
    public GeneralResponse insert(Psyhchologist psyhchologist) {
        return null;
    }

    @Override
    public Psyhchologist findById(String id) {
        return null;
    }
}
