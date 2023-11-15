package com.socialmedia_solides.postssrv.services;

import com.socialmedia_solides.postssrv.entities.Comments;
import com.socialmedia_solides.postssrv.entities.Post;
import com.socialmedia_solides.postssrv.models.CommentsDto;
import com.socialmedia_solides.postssrv.repositories.CommentRepository;
import com.socialmedia_solides.postssrv.repositories.PostRepository;
import com.socialmedia_solides.postssrv.services.exceptions.EntityNotFoundException;
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
                () -> new EntityNotFoundException("Comentário não encontrado: " + id));
    }

    public Comments create(CommentsDto commentsDto) {

        Post post = postRepository.findById(commentsDto.getPostId()).orElseThrow(
                () -> new EntityNotFoundException("Post não encontrado: " + commentsDto.getPostId()));

        Comments comments = new Comments();
        List<Comments> list = post.getComments();

        comments.setComment(commentsDto.getComment());
        comments.setCreatedBy(commentsDto.getCreatedBy());
        comments.setCreatedAt(LocalDateTime.now());
        comments.setCreatedBy("Name");

        list.add(comments);
//        post.setComments(list);


//        return postRepository.save(post);
        return commentRepository.save(comments);
    }

    public void deleteById(Long commentId, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("Post não encontrado: " + postId));

        List<Comments> listOfComments = post.getComments();

        Comments comments = commentRepository.findById(commentId).orElseThrow(
                () -> new EntityNotFoundException("Comentário não encontrado: " + commentId));

        listOfComments.remove(comments);
        post.setComments(listOfComments);
        postRepository.save(post);
        commentRepository.delete(comments);
    }
}
