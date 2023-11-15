package com.socialmedia_solides.postssrv.resources;

import com.socialmedia_solides.postssrv.entities.Post;
import com.socialmedia_solides.postssrv.models.PostDto;
import com.socialmedia_solides.postssrv.repositories.PostRepository;
import com.socialmedia_solides.postssrv.services.PostSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostSrv postSrv;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto) {
        Post post = postSrv.create(postDto);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        Post post = postSrv.findById(id);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        postSrv.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
