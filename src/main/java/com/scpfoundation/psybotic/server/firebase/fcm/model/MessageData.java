package com.scpfoundation.psybotic.server.firebase.fcm.model;

import com.scpfoundation.psybotic.server.firebase.firestore.annotation.DocumentId;

import java.sql.Timestamp;
import java.util.Date;

public class MessageData {
    @DocumentId
    private String id;
    private String chatRoomId;
    private String receiverId;
    private String senderId;
    private String message;
    private String senderFirstName;
    private String senderLastName;
    private Date date = new Date(System.currentTimeMillis());

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
