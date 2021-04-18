package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.ChatRoomResponse;
import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.models.User;
import com.scpfoundation.psybotic.server.repositories.ChatMessageRepository;
import com.scpfoundation.psybotic.server.serviceInterfaces.IChatMessageService;
import com.scpfoundation.psybotic.server.serviceInterfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ChatMessageService
        extends CRUDService<ChatMessageRepository, ChatMessage>
        implements IChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final IUserService userService;

    public ChatMessageService(ChatMessageRepository chatMessageRepository, IUserService userService) {
        super(chatMessageRepository);
        this.chatMessageRepository = chatMessageRepository;
        this.userService = userService;
    }

    @Override
    public List<ChatMessage> findByReceiverId(String id) {
        return chatMessageRepository.findByReceiverId(id);
    }

    @Override
    public List<ChatRoomResponse> getChatRooms(String userId) {
        HashMap<String, User> users = new HashMap<>();
        List<ChatRoomResponse> res = new ArrayList<>();
        List<ChatMessage> messages = chatMessageRepository.findBySenderIdOrReceiverIdOrderByDateDesc(userId, userId);
        for (ChatMessage message :
                messages) {
            if (!message.getReceiverId().equals("chatbot") && !message.getSenderId().equals("chatbot")) {
                User sender = userService.findById(message.getSenderId());
                User receiver = userService.findById(message.getReceiverId());
                if (sender != null && receiver != null) {
                    User opp = (sender.getId().equals(userId)) ? receiver : sender;
                    if (!users.containsKey(message.getChatRoomId())) {
                        ChatRoomResponse tmp = new ChatRoomResponse();
                        tmp.setLastMessage(message);
                        tmp.setUser(opp);
                        users.put(message.getChatRoomId(), opp);
                        res.add(tmp);
                    }
                }
            }

        }
        return res;
    }

    @Override
    public List<ChatMessage> getChatHistory(String chatRoomId) {
        return chatMessageRepository.findByChatRoomIdOrderByDateDesc(chatRoomId);
    }
}
