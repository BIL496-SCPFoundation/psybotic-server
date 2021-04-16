package com.scpfoundation.psybotic.server.firebase.fcm;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.firebase.fcm.model.AIResponse;

public class MessageResponse extends GeneralResponse {
    private AIResponse chatbotResponse;

    public AIResponse getChatbotResponse() {
        return chatbotResponse;
    }

    public void setChatbotResponse(AIResponse chatbotResponse) {
        this.chatbotResponse = chatbotResponse;
    }
}
