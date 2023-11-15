package com.socialmedia_solides.postssrv.resources;

import com.socialmedia_solides.postssrv.entities.Comments;
import com.socialmedia_solides.postssrv.entities.Post;
import com.socialmedia_solides.postssrv.models.CommentsDto;
import com.socialmedia_solides.postssrv.services.CommentsSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentResource {

    @Autowired
    private CommentsSrv commentsSrv;

    @GetMapping
    public ResponseEntity<List<Comments>> findByUser(@RequestParam String user) {
        List<Comments> byUser = commentsSrv.findByUser(user);
        return ResponseEntity.ok(byUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comments> findById(@PathVariable Long id) {
        Comments byId = commentsSrv.findById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Comments> create(@RequestBody CommentsDto commentsDto,
                                           @RequestHeader(value = "clientId") String clientId) {
        Comments comments = commentsSrv.create(commentsDto, clientId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{commentId}/post/{postId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long commentId, @PathVariable Long postId,
                                           @RequestHeader(value = "clientId") String clientId) {
        commentsSrv.deleteById(commentId, postId, clientId);
        return ResponseEntity.status(200).build();
    }

}
