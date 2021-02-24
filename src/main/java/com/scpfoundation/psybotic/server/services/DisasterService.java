package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Disaster;
import com.scpfoundation.psybotic.server.repositories.DisasterRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IDisasterService;

public class DisasterService implements IDisasterService {

    private final DisasterRepository disasterRepository;

    public DisasterService(DisasterRepository disasterRepository) {
        this.disasterRepository = disasterRepository;
    }


    @Override
    public GeneralResponse insert(Disaster disaster) {
        return null;
    }

    @Override
    public Disaster findById(String id) {
        return null;
    }
}
