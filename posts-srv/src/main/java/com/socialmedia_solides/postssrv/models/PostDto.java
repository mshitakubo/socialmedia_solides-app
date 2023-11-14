package com.socialmedia_solides.postssrv.models;

import com.socialmedia_solides.postssrv.entities.Comments;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String postText;
    private String image;
    private String link;
    private String users;

    public PostDto() {
    }

    public PostDto(Long id, String postText, String image, String link, String users) {
        this.id = id;
        this.postText = postText;
        this.image = image;
        this.link = link;
        this.users = users;
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

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
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
