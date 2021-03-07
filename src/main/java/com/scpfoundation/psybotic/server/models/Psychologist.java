package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Psychologist implements BasicModel<String>{
    @Id
    private String id;
    private Date createdDate;
    private String firstName;
    private String lastName;
    private String title;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
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
