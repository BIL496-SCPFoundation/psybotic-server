package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Psyhchologist {
    @Id
    private String id;
    private Timestamp createdDate;

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Psyhchologist)) return false;
        Psyhchologist psyhchologist = (Psyhchologist) o;
        return id.equals(psyhchologist.id) &&
                Objects.equals(getCreatedDate(), psyhchologist.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getCreatedDate());
    }
}
