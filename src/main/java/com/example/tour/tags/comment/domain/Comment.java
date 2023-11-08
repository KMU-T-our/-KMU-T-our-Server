package com.example.tour.tags.comment.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.comment.dto.CommentCreateRequest;
import com.example.tour.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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

    @Column(nullable = false)
    @CreatedDate
    private String createDateTime;

    public Comment(Tag tag, User user, CommentCreateRequest request) {
        this.user = user;
        this.tag = tag;
        this.content = request.getContent();
        this.createDateTime = request.getCreateDateTime();

    }
}
