package com.example.tour.tags.comment;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTag(Tag tag);
}
