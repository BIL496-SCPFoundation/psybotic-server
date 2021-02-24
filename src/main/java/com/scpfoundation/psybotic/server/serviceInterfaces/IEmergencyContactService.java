package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.models.User;

public interface IEmergencyContactService {

    GeneralResponse insert(EmergencyContact emergencyContact);

    EmergencyContact findById(String id);

}
