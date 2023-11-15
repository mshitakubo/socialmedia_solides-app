package com.socialmedia_solides.picturessrv.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String createdBy;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Images> images;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    public Album() {
    }

    public Album(String name, String createdBy, List<Images> images) {
        this.name = name;
        this.createdBy = createdBy;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalDateTime() {
        return createdAt;
    }

    public void setLocalDateTime(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Images> getImages() {
        return images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
