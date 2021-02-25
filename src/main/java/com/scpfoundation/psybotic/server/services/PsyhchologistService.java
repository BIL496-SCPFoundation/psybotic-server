package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psyhchologist;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.PsyhchologistRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IPsyhchologistService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PsyhchologistService implements IPsyhchologistService {

    private final PsyhchologistRepository psyhchologistRepository;

    public PsyhchologistService(PsyhchologistRepository psyhchologistRepository) {
        this.psyhchologistRepository = psyhchologistRepository;
    }

    @Override
    public GeneralResponse insert(Psyhchologist psyhchologist) {
        GeneralResponse res = new GeneralResponse();
        try {
            psyhchologistRepository.save(psyhchologist);
            res.setMessage("Psychologist saved successfully");
            res.setStatus(200);
        } catch (Exception e) {
            res.setError(e.getMessage());
            res.setMessage("Encountered an error while saving Psychologist");
            res.setStatus(500); // 500: internal server error
        }
        return res;
    }

    @Override
    public Psyhchologist findById(String id) {
        Optional<Psyhchologist> optionalUser = psyhchologistRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
