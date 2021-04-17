package com.scpfoundation.psybotic.server.models;

import com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData;
import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class ChatMessage implements BasicModel<String>{
    @Id
    private String id;
    private String chatRoomId;
    private String receiverId;
    private String senderId;
    private String message;
    private String senderFirstName;
    private String senderLastName;
    private Timestamp date;

    public ChatMessage(MessageData messageData) {
        this.id = messageData.getId();
        this.chatRoomId = messageData.getChatRoomId();
        this.receiverId = messageData.getReceiverId();
        this.senderId = messageData.getSenderId();
        this.message = messageData.getMessage();
        this.senderFirstName = messageData.getSenderFirstName();
        this.senderLastName = messageData.getSenderLastName();
        this.date = messageData.getDate();
    }

    public ChatMessage() {
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMessage)) return false;
        ChatMessage that = (ChatMessage) o;
        return getId().equals(that.getId()) && Objects.equals(getChatRoomId(), that.getChatRoomId()) && getReceiverId().equals(that.getReceiverId()) && getSenderId().equals(that.getSenderId()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getSenderFirstName(), that.getSenderFirstName()) && Objects.equals(getSenderLastName(), that.getSenderLastName()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getChatRoomId(), getReceiverId(), getSenderId(), getMessage(), getSenderFirstName(), getSenderLastName(), getDate());
    }
}
