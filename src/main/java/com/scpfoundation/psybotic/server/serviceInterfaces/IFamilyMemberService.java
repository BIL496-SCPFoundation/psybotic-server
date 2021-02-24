package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.FamilyMemberUser;
import com.scpfoundation.psybotic.server.models.User;

public interface IFamilyMemberService {

    GeneralResponse insert(FamilyMemberUser user);

    FamilyMemberUser findById(String id);

}
