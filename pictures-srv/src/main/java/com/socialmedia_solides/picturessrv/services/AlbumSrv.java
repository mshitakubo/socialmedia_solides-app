package com.socialmedia_solides.picturessrv.services;

import com.socialmedia_solides.picturessrv.entities.Album;
import com.socialmedia_solides.picturessrv.models.AlbumDto;
import com.socialmedia_solides.picturessrv.repositories.AlbumRepository;
import com.socialmedia_solides.picturessrv.services.exceptions.EntityNotFoundException;
import com.socialmedia_solides.postssrv.services.exceptions.ForbiddenException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AlbumSrv {

    @Autowired
    private AlbumRepository albumRepository;

    public Album create(AlbumDto albumDto, String clientId) {
        Album album = new Album();
        BeanUtils.copyProperties(albumDto, album);
        album.setLocalDateTime(LocalDateTime.now());
        album.setCreatedBy(clientId);
        return albumRepository.save(album);
    }

    public Album findById(Long id) {
        return albumRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("album not found, id: " + id));
    }

    public void deleteById(Long id, String clientId) {
        Album album = albumRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("album not found, id: " + id));

        if (!album.getCreatedBy().equals(clientId)) {
            throw new ForbiddenException("forbidden, id: " + clientId);
        }

        albumRepository.deleteById(id);
    }


}
