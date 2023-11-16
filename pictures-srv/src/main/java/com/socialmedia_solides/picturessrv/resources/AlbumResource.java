package com.socialmedia_solides.picturessrv.resources;

import com.socialmedia_solides.picturessrv.entities.Album;
import com.socialmedia_solides.picturessrv.entities.Images;
import com.socialmedia_solides.picturessrv.models.AlbumDto;
import com.socialmedia_solides.picturessrv.models.ImagesDto;
import com.socialmedia_solides.picturessrv.services.AlbumSrv;
import com.socialmedia_solides.picturessrv.services.ImagesSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/album")
public class AlbumResource {

    @Autowired
    private AlbumSrv albumSrv;

    @Autowired
    private ImagesSrv imagesSrv;

    @PostMapping
    public ResponseEntity<Album> create(@RequestBody @Valid AlbumDto albumDto,
                                        @RequestHeader(value = "clientId") String clientId) {
        Album album = albumSrv.create(albumDto, clientId);
        return ResponseEntity.status(201).body(album);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> findById(@PathVariable Long id) {
        Album album = albumSrv.findById(id);
        return ResponseEntity.ok(album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id,
                                           @RequestHeader(value = "clientId") String clientId) {
        albumSrv.deleteById(id, clientId);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/photos")
    public ResponseEntity<Images> sendImages(@RequestBody @Valid ImagesDto imagesDto) {
        Images images = imagesSrv.sendImages(imagesDto);
        return ResponseEntity.ok(images);
    }

}
