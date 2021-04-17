package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;

import java.util.List;


public interface IChatMessageService extends ICRUDService<ChatMessage, String>{
    List<ChatMessage> findByRecaiverId(String id);
}
