package com.socialmedia_solides.picturessrv.repositories;

import com.socialmedia_solides.picturessrv.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
