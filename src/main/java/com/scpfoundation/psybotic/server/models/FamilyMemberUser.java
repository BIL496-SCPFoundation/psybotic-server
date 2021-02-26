package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class FamilyMemberUser implements BasicModel<String>{
    @Id
    private String id;
    private String phone;
    private String type;
    private String mail;
    private String firstName;
    private String age;
    private String gender;
    private String city;
    private String maritalStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public String getMail() {
        return mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FamilyMemberUser)) return false;
        FamilyMemberUser that = (FamilyMemberUser) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getMail(), that.getMail()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getAge(), that.getAge()) &&
                Objects.equals(getGender(), that.getGender()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getMaritalStatus(), that.getMaritalStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getPhone(), getType(), getMail(), getFirstName(), getAge(), getGender(), getCity(),
                getMaritalStatus());
    }


}
