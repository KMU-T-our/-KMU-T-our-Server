package com.example.tour.tags.comment.dto;

import com.example.tour.tags.comment.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CommentResponse {
    private Long commentId;
    private Long tagId;
    private Long userId;
    private String writer;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss", timezone = "Asia/Seoul")
    private Date createDateTime;

    public CommentResponse(Comment comment){
        this.commentId = comment.getCommentId();
        this.tagId = comment.getTag().getTagId();
        this.userId = comment.getUser().getId();
        this.writer = comment.getUser().getName();
        this.content = comment.getContent();
        this.createDateTime = comment.getCreateDateTime();
    }
}
