package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psychologist;

public interface IPsychologistService {

    GeneralResponse insert(Psychologist psychologist);

    Psychologist findById(String id);

}
