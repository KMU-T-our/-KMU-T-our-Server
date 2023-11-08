package com.example.tour.tags.comment.dto;

import com.example.tour.tags.comment.domain.Comment;
import lombok.Getter;


@Getter
public class CommentResponse {
    private Long commentId;
    private Long tagId;
    private String writer;
    private String content;
    private String createDateTime;

    public CommentResponse(Comment comment){
        this.commentId = comment.getCommentId();
        this.tagId = comment.getTag().getTagId();
        this.writer = comment.getUser().getName();
        this.content = comment.getContent();
        this.createDateTime = comment.getCreateDateTime();
    }
}
