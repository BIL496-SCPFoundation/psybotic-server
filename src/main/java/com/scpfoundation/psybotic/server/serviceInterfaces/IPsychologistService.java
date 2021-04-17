package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psychologist;

import java.util.List;

public interface IPsychologistService extends ICRUDService<Psychologist, String> {

    List<Psychologist> getApplicants();

    List<Psychologist> getVerifiedPsychologists();

    List<Psychologist> getOldApplicants();
}
