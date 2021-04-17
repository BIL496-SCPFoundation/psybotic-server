package com.scpfoundation.psybotic.server.custom;

import com.scpfoundation.psybotic.server.models.ChatMessage;
import com.scpfoundation.psybotic.server.models.User;

public class ChatRoomResponse {
    private User user;
    private ChatMessage lastMessage;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChatMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(ChatMessage lastMessage) {
        this.lastMessage = lastMessage;
    }
}
