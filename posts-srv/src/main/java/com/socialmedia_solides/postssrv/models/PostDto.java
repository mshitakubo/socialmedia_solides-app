package com.socialmedia_solides.postssrv.models;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class PostDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String postText;
    private String image;
    private String link;
    @NotBlank
    private String userEmail;

    public PostDto() {
    }

    public PostDto(Long id, String postText, String image, String link, String userEmail) {
        this.id = id;
        this.postText = postText;
        this.image = image;
        this.link = link;
        this.userEmail = userEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
