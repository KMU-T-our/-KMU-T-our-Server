package com.example.tour.tags.home;

import com.example.tour.tags.home.dto.HomeTagCreateRequest;
import com.example.tour.tags.home.dto.HomeTagResponse;
import com.example.tour.tags.home.dto.HomeTagUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class HomeTagsController {

    private final HomeTagsServiceImpl homeTagsService;

    @PostMapping("/api/tags/home")
    public void saveHomeTags(@RequestBody HomeTagCreateRequest request) {
        homeTagsService.saveHomeTag(request);
    }

    @GetMapping("/api/tags/home")
    public HomeTagResponse getHomeTagByTagId(@RequestParam Long tagId) {
        return homeTagsService.findByTagId(tagId);
    }

    @PutMapping("/api/tags/home")
    public void updateHomeTags(@RequestBody HomeTagUpdateRequest request) {
        homeTagsService.updaterHomeTag(request);
    }

    @DeleteMapping("/api/tags/home")
    public void deleteHomeTagByTagId(@RequestParam Long tagId) {
        homeTagsService.deleteHomeTag(tagId);
    }
}
