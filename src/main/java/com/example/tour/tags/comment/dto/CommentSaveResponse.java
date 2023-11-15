package com.example.tour.tags.comment.dto;

import com.example.tour.tags.comment.domain.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentSaveResponse {
    private Long commentId;
    private Long tagId;
    private Long userId;

    public CommentSaveResponse(Comment comment, Long tagId, Long userId){
        this.commentId = comment.getCommentId();
        this.tagId = tagId;
        this.userId = userId;
    }
}
