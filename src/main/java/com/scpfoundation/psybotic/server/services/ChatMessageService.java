package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.repositories.ChatMessageRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IChatMessageService;

public class ChatMessageService implements IChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }


    @Override
    public GeneralResponse insert(ChatMessage chatMessage) {
        return null;
    }

    @Override
    public ChatMessage findById(String id) {
        return null;
    }
}
