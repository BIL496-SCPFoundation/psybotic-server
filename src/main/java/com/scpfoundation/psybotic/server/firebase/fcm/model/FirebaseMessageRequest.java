package com.scpfoundation.psybotic.server.firebase.fcm.model;

public class FirebaseMessageRequest {

    private String title;
    private String message;
    private String topic;
    private String token;
    private Integer userId;
    private com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData data;

    public com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData getData() {
        return data;
    }

    public void setData(com.scpfoundation.psybotic.server.firebase.fcm.model.MessageData data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
