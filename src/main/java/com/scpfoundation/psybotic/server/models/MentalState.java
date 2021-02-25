package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class MentalState {

    @Id
    private String id;
    private String emotionalState;
    private Time time;
    private Date createdDate;

    public String getEmotional_state() {
        return emotionalState;
    }

    public void setEmotional_state(String emotional_state) {
        this.emotionalState = emotional_state;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentalState that = (MentalState) o;
        return Objects.equals(id, that.id) && Objects.equals(emotionalState, that.emotionalState) && Objects.equals(time, that.time) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emotionalState, time, createdDate);
    }

}
