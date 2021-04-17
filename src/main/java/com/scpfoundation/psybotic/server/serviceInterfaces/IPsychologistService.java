package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psychologist;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPsychologistService extends ICRUDService<Psychologist, String> {

    List<Psychologist> getApplicants();

    List<Psychologist> getVerifiedPsychologists();

    List<Psychologist> getOldApplicants();

    @Override
    ResponseEntity<GeneralResponse> update(Psychologist entity);
}
