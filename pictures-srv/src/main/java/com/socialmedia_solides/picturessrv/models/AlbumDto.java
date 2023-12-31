package com.socialmedia_solides.picturessrv.models;

import com.socialmedia_solides.picturessrv.entities.Images;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

public class AlbumDto {

    private Long id;
    @NotBlank
    private String name;
    private List<Images> images;

    public AlbumDto() {
    }

    public AlbumDto(String name, List<Images> images) {
        this.name = name;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumDto albumDto = (AlbumDto) o;
        return Objects.equals(id, albumDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
