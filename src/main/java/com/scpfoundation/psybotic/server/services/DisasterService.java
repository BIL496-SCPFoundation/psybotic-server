package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.models.Disaster;
import com.scpfoundation.psybotic.server.repositories.DisasterRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IDisasterService;
import org.springframework.stereotype.Service;


@Service
public class DisasterService
        extends CRUDService<DisasterRepository, Disaster>
        implements IDisasterService {

    private final DisasterRepository disasterRepository;

    public DisasterService(DisasterRepository disasterRepository) {
        super(disasterRepository);
        this.disasterRepository = disasterRepository;
    }

}
