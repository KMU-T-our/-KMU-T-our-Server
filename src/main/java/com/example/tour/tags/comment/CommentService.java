package com.example.tour.tags.comment;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.config.middletable.tag.TagRepository;
import com.example.tour.config.middletable.tag.TagService;
import com.example.tour.tags.comment.domain.Comment;
import com.example.tour.tags.comment.dto.CommentCreateRequest;
import com.example.tour.tags.comment.dto.CommentResponse;
import com.example.tour.user.UserRepository;
import com.example.tour.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final TagService tagService;

    @Transactional
    public void saveComment(CommentCreateRequest request){
        Tag tag = tagService.getInstance();
        User user = userRepository.findById(request.getUserId()).orElseThrow(IllegalArgumentException::new);
        Comment comment = commentRepository.save(new Comment(tag, user, request));
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> getComment(Long tagId){
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalArgumentException::new);
        return commentRepository.findByTag(tag).stream().map(CommentResponse::new).collect(Collectors.toList());
    }

    @Transactional
    public void deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow(IllegalArgumentException::new);
        commentRepository.delete(comment);
    }
}

