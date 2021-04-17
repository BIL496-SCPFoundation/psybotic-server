package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.models.EmergencyContact;

import java.util.List;

public interface IEmergencyContactService extends ICRUDService<EmergencyContact, String>{
    List<EmergencyContact> findByEmergencyContact(String id);
}
