package com.example.tour.tags.comment.dto;

import com.example.tour.tags.comment.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
public class CommentResponse {
    private Long commentId;
    private Long tagId;
    private Long userId;
    private String writer;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDateTime;
    private String timeElapsed;

    public CommentResponse(Comment comment) {
        this.commentId = comment.getCommentId();
        this.tagId = comment.getTag().getTagId();
        this.userId = comment.getUser().getId();
        this.writer = comment.getUser().getName();
        this.content = comment.getContent();
        this.createDateTime = comment.getCreateDateTime();
        this.timeElapsed = calculateTimeElapsed(comment.getCreateDateTime());
    }

    private String calculateTimeElapsed(LocalDateTime createDateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Duration duration = Duration.between(createDateTime, currentDateTime);

        long seconds = duration.getSeconds();
        if (seconds < 60) {
            return seconds + "초 전";
        } else if (seconds < 3600) {
            long minutes = seconds / 60;
            return minutes + "분 전";
        } else if (seconds < 86400) {
            long hours = seconds / 3600;
            return hours + "시간 전";
        } else if (seconds < 2592000) {
            long days = seconds / 86400;
            return days + "일 전";
        } else if (seconds < 31536000) {
            long months = seconds / 2592000;
            return months + "달 전";
        } else {
            long years = seconds / 31536000;
            return years + "년 전";
        }
    }
}
