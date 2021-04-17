package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psychologist;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.PsychologistRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IPsychologistService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsychologistService
        extends CRUDService<PsychologistRepository, Psychologist>
        implements IPsychologistService {

    private final PsychologistRepository psychologistRepository;
    private final IUserService userService;

    public PsychologistService(PsychologistRepository psychologistRepository, IUserService userService) {
        super(psychologistRepository);
        this.psychologistRepository = psychologistRepository;
        this.userService = userService;
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

    @Override
    public ResponseEntity<GeneralResponse> update(Psychologist updatedEntity) {
        ResponseEntity<GeneralResponse> res =  super.update(updatedEntity);
        User u = userService.findById(updatedEntity.getId());
        if (u != null) {
            u.setPsychologist(updatedEntity.isApproved());
            userService.update(u);
        }
        return res;
    }
}
