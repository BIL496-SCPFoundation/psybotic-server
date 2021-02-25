package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psychologist;
import com.scpfoundation.psybotic.server.repositories.PsychologistRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IPsychologistService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PsychologistService implements IPsychologistService {

    private final PsychologistRepository psychologistRepository;

    public PsychologistService(PsychologistRepository psychologistRepository) {
        this.psychologistRepository = psychologistRepository;
    }

    @Override
    public GeneralResponse insert(Psychologist psychologist) {
        GeneralResponse res = new GeneralResponse();
        try {
            psychologistRepository.save(psychologist);
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
    public Psychologist findById(String id) {
        Optional<Psychologist> optionalUser = psychologistRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
