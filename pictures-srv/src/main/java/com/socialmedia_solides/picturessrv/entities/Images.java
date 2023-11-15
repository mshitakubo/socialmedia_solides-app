package com.socialmedia_solides.picturessrv.entities;


import javax.persistence.*;

@Entity
@Table(name = "tb_images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @ManyToOne
    @JoinColumn(name="album_id")
    private Album album;

    public Images() {

    }

    public Images(String path, Album album) {
        this.path = path;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Album getPictures() {
        return album;
    }

    public void setPictures(Album album) {
        this.album = album;
    }
}
