package com.scpfoundation.psybotic.server.firebase.fcm.model;

public class AIResponse {
    private String recipient_id;
    private String text;

    public AIResponse() {
        this.text = "Sorry. I could not understand what you are saying. Could you please clarify.";
    }

    public AIResponse(String recipient_id) {
        this();
        this.recipient_id = recipient_id;
    }

    public AIResponse(String recipient_id, String text) {
        this.recipient_id = recipient_id;
        this.text = text;
    }

    public String getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
