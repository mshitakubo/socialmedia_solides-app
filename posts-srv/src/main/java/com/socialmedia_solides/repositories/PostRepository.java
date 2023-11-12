package com.socialmedia_solides.repositories;

import com.socialmedia_solides.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
