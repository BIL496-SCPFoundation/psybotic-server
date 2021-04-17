package com.scpfoundation.psybotic.server.models;

import com.scpfoundation.psybotic.server.types.AgeRange;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class Article implements BasicModel<String>{
    @Id
    private String id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "URL is mandatory")
    private String url;
    private User publisher;
    @NotNull(message = "Age range is mandatory")
    private AgeRange ageRange;
    private Date createdData = new Date(System.currentTimeMillis());
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }

    public Date getCreatedData() {
        return createdData;
    }

    public void setCreatedData(Date createdData) {
        this.createdData = createdData;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getId(), article.getId()) && Objects.equals(getTitle(), article.getTitle()) && Objects.equals(getUrl(), article.getUrl()) && Objects.equals(getPublisher(), article.getPublisher()) && getAgeRange() == article.getAgeRange();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getUrl(), getPublisher(), getAgeRange());
    }
}
