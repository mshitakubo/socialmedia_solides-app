package com.socialmedia_solides.picturessrv.services;

import com.socialmedia_solides.picturessrv.entities.Album;
import com.socialmedia_solides.picturessrv.models.AlbumDto;
import com.socialmedia_solides.picturessrv.repositories.AlbumRepository;
import com.socialmedia_solides.picturessrv.services.exceptions.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlbumSrv {

    @Autowired
    private AlbumRepository albumRepository;

    public Album create(AlbumDto albumDto) {
        Album album = new Album();
        BeanUtils.copyProperties(albumDto, album);
        album.setLocalDateTime(LocalDateTime.now());
        return albumRepository.save(album);
    }

    public Album findById(Long id) {
        return albumRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Album não encontrado: " + id));
    }

    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }


}
