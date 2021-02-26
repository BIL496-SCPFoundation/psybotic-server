package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Objects;

public class Psychologist {
    @Id
    private String id;
    private Timestamp createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Psychologist)) return false;
        Psychologist psychologist = (Psychologist) o;
        return id.equals(psychologist.id) &&
                Objects.equals(getCreatedDate(), psychologist.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getCreatedDate());
    }
}
