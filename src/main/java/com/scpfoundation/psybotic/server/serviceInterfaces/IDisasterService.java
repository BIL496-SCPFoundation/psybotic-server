package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.Disaster;
import com.scpfoundation.psybotic.server.models.User;

public interface IDisasterService {

    GeneralResponse insert(Disaster disaster);

    Disaster findById(String id);

}
