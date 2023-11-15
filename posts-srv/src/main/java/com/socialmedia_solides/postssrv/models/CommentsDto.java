package com.socialmedia_solides.postssrv.models;

import java.io.Serializable;
import java.util.Objects;

public class CommentsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String comment;
    private String userEmail;
    private Long postId;

    public CommentsDto() {

    }

    public CommentsDto(Long id, String comment, String userEmail, Long post) {
        this.id = id;
        this.comment = comment;
        this.userEmail = userEmail;
        this.postId = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsDto comments = (CommentsDto) o;
        return Objects.equals(id, comments.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
