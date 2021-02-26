package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class ChatMessage implements BasicModel<String>{
    @Id
    private String id;
    private String message;
    private Timestamp sentDate;
    private String senderId;
    private String receiverId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSentDate() {
        return sentDate;
    }

    public void setSentDate(Timestamp sentDate) {
        this.sentDate = sentDate;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
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
