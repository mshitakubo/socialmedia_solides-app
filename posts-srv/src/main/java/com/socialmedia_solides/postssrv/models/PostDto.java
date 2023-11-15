package com.socialmedia_solides.postssrv.models;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class PostDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String text;
    private String image;
    private String link;
    @NotBlank
    private String createdBy;

    public PostDto() {
    }

    public PostDto(Long id, String text, String image, String link, String createdBy) {
        this.id = id;
        this.text = text;
        this.image = image;
        this.link = link;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto post = (PostDto) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
