package com.scpfoundation.psybotic.server.models;


import org.springframework.data.annotation.Id;

import java.util.Objects;

public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String googleId;
    private Character gender;
    private String city;
    private String maritalStatus;

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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(geteMail(), user.geteMail()) &&
                Objects.equals(getGoogleId(), user.getGoogleId()) &&
                Objects.equals(getGender(), user.getGender()) &&
                Objects.equals(getCity(), user.getCity()) &&
                Objects.equals(getMaritalStatus(), user.getMaritalStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getFirstName(), getLastName(), geteMail(), getGoogleId(), getGender(), getCity(), getMaritalStatus());
    }
}
