package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class FamilyMemberUser implements BasicModel<String>{
    @Id
    private String id;
    private String googleId;
    private String phone;
    private String type;
    private String mail;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String city;
    private String maritalStatus;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
        if (!(o instanceof FamilyMemberUser)) return false;
        FamilyMemberUser that = (FamilyMemberUser) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getGoogleId(), that.getGoogleId()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getType(), that.getType()) && Objects.equals(getMail(), that.getMail()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getAge(), that.getAge()) && Objects.equals(getGender(), that.getGender()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getMaritalStatus(), that.getMaritalStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGoogleId(), getPhone(), getType(), getMail(), getFirstName(), getLastName(), getAge(), getGender(), getCity(), getMaritalStatus());
    }
}
