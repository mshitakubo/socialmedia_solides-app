package com.socialmedia_solides.postssrv.resources;

import com.socialmedia_solides.postssrv.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String getSout() {
        return "teste";
    }
}
