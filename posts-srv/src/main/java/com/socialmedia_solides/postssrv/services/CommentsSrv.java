package com.socialmedia_solides.postssrv.services;

import com.socialmedia_solides.postssrv.entities.Comments;
import com.socialmedia_solides.postssrv.entities.Post;
import com.socialmedia_solides.postssrv.models.CommentsDto;
import com.socialmedia_solides.postssrv.repositories.CommentRepository;
import com.socialmedia_solides.postssrv.repositories.PostRepository;
import com.socialmedia_solides.postssrv.services.exceptions.EntityNotFoundException;
import com.socialmedia_solides.postssrv.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentsSrv {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Comments> findByUser(String user) {
        return commentRepository.findByCreatedBy(user);
    }

    public Comments findById(Long id) {
        return commentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("comment not found, id: " + id));
    }

    public Comments create(CommentsDto commentsDto, String clientId) {

        Post post = postRepository.findById(commentsDto.getPostId()).orElseThrow(
                () -> new EntityNotFoundException("post not found, id: " + commentsDto.getPostId()));

        Comments comments = new Comments();
        List<Comments> list = post.getComments();

        comments.setComment(commentsDto.getComment());
        comments.setCreatedBy(clientId);
        comments.setCreatedAt(LocalDateTime.now());

        list.add(comments);
        return commentRepository.save(comments);
    }

    public void deleteById(Long commentId, Long postId, String clientId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("post not found, postId: " + postId));

        List<Comments> listOfComments = post.getComments();

        Comments comments = commentRepository.findById(commentId).orElseThrow(
                () -> new EntityNotFoundException("comment not found, commentId: " + commentId));

        if (!comments.getCreatedBy().equals(clientId)) {
            throw new ForbiddenException("forbidden, clientId " + clientId);
        }

        listOfComments.remove(comments);
        post.setComments(listOfComments);
        postRepository.save(post);
        commentRepository.delete(comments);
    }
}
