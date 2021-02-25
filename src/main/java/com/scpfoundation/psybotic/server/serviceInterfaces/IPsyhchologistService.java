package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Psyhchologist;
import com.scpfoundation.psybotic.server.models.User;

public interface IPsyhchologistService {

    GeneralResponse insert(Psyhchologist psyhchologist);

    Psyhchologist findById(String id);

}
