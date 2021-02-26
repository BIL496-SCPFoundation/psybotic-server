package com.scpfoundation.psybotic.server.models;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class EmergencyContact implements BasicModel<String>{
    @Id
    private String id;
    private String phone;
    private String type;
    private String mail;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmergencyContact)) return false;
        EmergencyContact that = (EmergencyContact) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getMail(), that.getMail()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getPhone(), getType(), getMail(), getName());
    }

}
