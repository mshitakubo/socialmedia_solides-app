package com.socialmedia_solides.postssrv.services;

import com.socialmedia_solides.postssrv.entities.Post;
import com.socialmedia_solides.postssrv.models.PostDto;
import com.socialmedia_solides.postssrv.repositories.PostRepository;
import com.socialmedia_solides.postssrv.services.exceptions.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostSrv {

    @Autowired
    private PostRepository postRepository;

    public Post create(PostDto postDto) {
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        post.setCreatedAt(LocalDateTime.now());
        post.setCreatedBy(postDto.getCreatedBy());
        return postRepository.save(post);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Post não encontrado: " + id));
    }

    public void deleteById(Long id) {
         postRepository.deleteById(id);
    }
}
