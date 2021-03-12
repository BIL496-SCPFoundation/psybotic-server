package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Objects;

public class Notification implements BasicModel<String> {
    @Id
    private String notificationId;
    private String userId;
    private String text_header;
    private String text;
    private boolean status;
    private boolean reply;
    private Date sendingDate;
    private Date replyDate;

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", userId='" + userId + '\'' +
                ", text_header='" + text_header + '\'' +
                ", text='" + text + '\'' +
                ", status=" + status +
                ", reply=" + reply +
                ", sendingDate=" + sendingDate +
                ", replyDate=" + replyDate +
                '}';
    }


    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getText_header() {
        return text_header;
    }

    public void setText_header(String text_header) {
        this.text_header = text_header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return isStatus() == that.isStatus() && isReply() == that.isReply() && Objects.equals(getNotificationId(), that.getNotificationId()) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getText_header(), that.getText_header()) && Objects.equals(getText(), that.getText()) && Objects.equals(getSendingDate(), that.getSendingDate()) && Objects.equals(getReplyDate(), that.getReplyDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNotificationId(), getUserId(), getText_header(), getText(), isStatus(), isReply(), getSendingDate(), getReplyDate());
    }


    @Override
    public String getId() {
        return notificationId;
    }
    @Override
    public void setId(String id) {
        this.notificationId = id;
    }
}
