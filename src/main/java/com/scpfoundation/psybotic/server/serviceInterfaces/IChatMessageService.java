package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.ChatRoomResponse;
import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;

import java.util.List;


public interface IChatMessageService extends ICRUDService<ChatMessage, String>{
    List<ChatMessage> findByReceiverId(String id);

    List<ChatRoomResponse> getChatRooms(String userId);
}
