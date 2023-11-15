package com.example.tour.tags.comment;

import com.example.tour.tags.comment.domain.Comment;
import com.example.tour.tags.comment.dto.CommentCreateRequest;
import com.example.tour.tags.comment.dto.CommentResponse;
import com.example.tour.wallet.spending.dto.response.SpendingResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/comment")
    public void saveComment(@RequestParam CommentCreateRequest request){
        commentService.saveComment(request);
    }

    @GetMapping("/api/comment")
    public List<CommentResponse> getComment(@RequestParam Long tagId){
        return commentService.getComment(tagId);
    }

    @DeleteMapping("/api/comment")
    public void deleteComment(@RequestParam Long commentId){
        commentService.deleteComment(commentId);
    }
}
