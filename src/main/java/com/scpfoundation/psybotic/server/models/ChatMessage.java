package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Objects;

public class ChatMessage {
    @Id
    private String id;
    private String message;
    private Date sen_date;
    private String sent_by;
    private String sent_to;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSen_date() {
        return sen_date;
    }

    public void setSen_date(Date sen_date) {
        this.sen_date = sen_date;
    }

    public String getSent_by() {
        return sent_by;
    }

    public void setSent_by(String sent_by) {
        this.sent_by = sent_by;
    }

    public String getSent_to() {
        return sent_to;
    }

    public void setSent_to(String sent_to) {
        this.sent_to = sent_to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMessage)) return false;
        ChatMessage that = (ChatMessage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getSen_date(), that.getSen_date()) &&
                Objects.equals(getSent_by(), that.getSent_by()) &&
                Objects.equals(getSent_to(), that.getSent_to());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getMessage(), getSen_date(), getSent_by(), getSent_to());
    }

}
