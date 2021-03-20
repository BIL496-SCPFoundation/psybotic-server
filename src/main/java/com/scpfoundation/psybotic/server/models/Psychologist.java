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
    private String expertise;
    private String ageOfInterest;
    private String[] educations;
    private String[] titles;
    private String biography;
    private String imageURL;
    private boolean approved = false;

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

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getAgeOfInterest() {
        return ageOfInterest;
    }

    public void setAgeOfInterest(String ageOfInterest) {
        this.ageOfInterest = ageOfInterest;
    }

    public String[] getEducations() {
        return educations;
    }

    public void setEducations(String[] educations) {
        this.educations = educations;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
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
