package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class ChatMessage {
    @Id
    private String id;
    private String message;
    private Timestamp sentDate;
    private String senderId;
    private String receiverId;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sen_date) {
        this.sentDate = sentDate;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSent_by(String sent_by) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setSent_to(String sent_to) {
        this.receiverId = sent_to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMessage)) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getSentDate(), that.getSentDate()) &&
                Objects.equals(getSenderId(), that.getSenderId()) &&
                Objects.equals(getReceiverId(), that.getReceiverId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getMessage(), getSentDate(), getSenderId(), getReceiverId());
    }

}
