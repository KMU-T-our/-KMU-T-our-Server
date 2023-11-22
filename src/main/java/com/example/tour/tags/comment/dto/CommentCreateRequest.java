package com.example.tour.tags.comment.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor

public class CommentCreateRequest {
    private Long tagId;
    private Long userId ;
    private String content;
}
