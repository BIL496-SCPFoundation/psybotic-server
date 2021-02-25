package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Disaster {
    @Id
    private String id;
    private String type;
    private String location;
    private Timestamp date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disaster)) return false;
        Disaster disaster = (Disaster) o;
        return Objects.equals(id, disaster.id) &&
                Objects.equals(getType(), disaster.getType()) &&
                Objects.equals(getLocation(), disaster.getLocation()) &&
                Objects.equals(getDate(), disaster.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getType(), getLocation(), getDate());
    }




}
