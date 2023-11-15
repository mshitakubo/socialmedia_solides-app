package com.socialmedia_solides.postssrv.repositories;

import com.socialmedia_solides.postssrv.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByUserEmail(String userEmail);
}
