package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.MentalState;
import com.scpfoundation.psybotic.server.models.User;

public interface IMentalStateService {

    GeneralResponse insert(MentalState user);

    MentalState findById(String id);

}
