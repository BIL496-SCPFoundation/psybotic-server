package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Objects;

public class Psyhchologist {
    @Id
    private String id;
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
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
