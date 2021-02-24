package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;


public interface IChatMessageService {

    GeneralResponse insert(ChatMessage chatMessage);

    ChatMessage findById(String id);

}
