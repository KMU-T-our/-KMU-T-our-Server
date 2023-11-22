package com.example.tour.tags.comment.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.comment.dto.CommentCreateRequest;
import com.example.tour.user.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@Table(name = "COMMENT")
@Entity
@NoArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "createdDateTime", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDateTime;

    @PrePersist
    protected void onCreate() throws ParseException {
        createDateTime = LocalDateTime.now();
    }

    public Comment(Tag tag, User user, CommentCreateRequest request) {
        this.user = user;
        this.tag = tag;
        this.content = request.getContent();

    }
}
