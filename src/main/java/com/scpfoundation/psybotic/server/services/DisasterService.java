package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Disaster;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.DisasterRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IDisasterService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisasterService implements IDisasterService {

    private final DisasterRepository disasterRepository;

    public DisasterService(DisasterRepository disasterRepository) {
        this.disasterRepository = disasterRepository;
    }


    @Override
    public GeneralResponse insert(Disaster disaster) {
        GeneralResponse res = new GeneralResponse();
        try {
            disasterRepository.save(disaster);
            res.setMessage("Disaster saved successfully");
            res.setStatus(200);
        } catch (Exception e) {
            res.setError(e.getMessage());
            res.setMessage("Encountered an error while saving disaster");
            res.setStatus(500); // 500: internal server error
        }
        return res;
    }

    @Override
    public Disaster findById(String id) {

        Optional<Disaster> optionalUser = disasterRepository.findById(id);
        return optionalUser.orElse(null);

    }
}
