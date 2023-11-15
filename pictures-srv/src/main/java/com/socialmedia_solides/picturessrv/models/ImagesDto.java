package com.socialmedia_solides.picturessrv.models;


public class ImagesDto {

    private String path;

    private Long albumId;

    public ImagesDto() {

    }

    public ImagesDto(String path, Long albumId) {
        this.path = path;
        this.albumId = albumId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
}
