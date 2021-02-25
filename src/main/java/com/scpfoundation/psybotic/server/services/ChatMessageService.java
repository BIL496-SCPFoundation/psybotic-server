package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.ChatMessageRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IChatMessageService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatMessageService implements IChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }


    @Override
    public GeneralResponse insert(ChatMessage chatMessage) {
        GeneralResponse res = new GeneralResponse();
        try {
            chatMessageRepository.save(chatMessage);
            res.setMessage("chatMessage saved successfully");
            res.setStatus(200);
        } catch (Exception e) {
            res.setError(e.getMessage());
            res.setMessage("Encountered an error while saving chatMessage");
            res.setStatus(500); // 500: internal server error
        }
        return res;
    }

    @Override
    public ChatMessage findById(String id) {
        Optional<ChatMessage> optionalUser = chatMessageRepository.findById(id);
        return optionalUser.orElse(null);
    }
}
