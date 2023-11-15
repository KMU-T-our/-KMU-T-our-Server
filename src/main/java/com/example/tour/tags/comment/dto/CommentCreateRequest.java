package com.example.tour.tags.comment.dto;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.user.domain.User;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor

public class CommentCreateRequest {
    private Long tagId;
    private Long userId ;
    private String content;
    private String createDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

}
