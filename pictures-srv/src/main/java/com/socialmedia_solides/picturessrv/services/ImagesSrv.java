package com.socialmedia_solides.picturessrv.services;

import com.socialmedia_solides.picturessrv.entities.Album;
import com.socialmedia_solides.picturessrv.entities.Images;
import com.socialmedia_solides.picturessrv.models.ImagesDto;
import com.socialmedia_solides.picturessrv.repositories.AlbumRepository;
import com.socialmedia_solides.picturessrv.repositories.ImageRepository;
import com.socialmedia_solides.picturessrv.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesSrv {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ImageRepository imageRepository;

    public Images sendImages(ImagesDto imagesDto) {

        Album album = albumRepository.findById(imagesDto.getAlbumId()).orElseThrow(
                () -> new EntityNotFoundException("album not found: " + imagesDto.getAlbumId()));

        Images images = new Images();
        List<Images> list = album.getImages();

        images.setPath(imagesDto.getPath());

        list.add(images);
        return imageRepository.save(images);
    }
}
