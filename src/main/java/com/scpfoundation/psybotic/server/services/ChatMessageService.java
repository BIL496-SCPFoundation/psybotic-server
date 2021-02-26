package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.ChatMessageRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IChatMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ChatMessageService
        extends CRUDService<ChatMessageRepository, ChatMessage>
        implements IChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        super(chatMessageRepository);
        this.chatMessageRepository = chatMessageRepository;
    }
}
