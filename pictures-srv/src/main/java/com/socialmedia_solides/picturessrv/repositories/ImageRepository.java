package com.socialmedia_solides.picturessrv.repositories;

import com.socialmedia_solides.picturessrv.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Images, Long> {
}
