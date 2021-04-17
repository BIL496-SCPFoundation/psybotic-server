package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.models.Psychologist;
import com.scpfoundation.psybotic.server.repositories.PsychologistRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IPsychologistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsychologistService
        extends CRUDService<PsychologistRepository, Psychologist>
        implements IPsychologistService {

    private final PsychologistRepository psychologistRepository;

    public PsychologistService(PsychologistRepository psychologistRepository) {
        super(psychologistRepository);
        this.psychologistRepository = psychologistRepository;
    }

    @Override
    public List<Psychologist> getApplicants() {
        return psychologistRepository.findAllApplicants();
    }

    @Override
    public List<Psychologist> getVerifiedPsychologists() {
        return psychologistRepository.findAllVerifiedPsychologists();
    }

    @Override
    public List<Psychologist> getOldApplicants() {
        return psychologistRepository.findAllOldApplicants();
    }

}
