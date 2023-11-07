package com.example.tour.config.middletable.tag;

import com.example.tour.config.middletable.tag.dto.TagResponse;
import com.example.tour.config.middletable.tag.dto.TagSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping("/api/tag")
    public TagResponse saveTag(@RequestBody TagSaveRequest request){
        return tagService.save(request);
    }

}
