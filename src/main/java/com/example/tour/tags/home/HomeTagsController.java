package com.example.tour.tags.home;

import com.example.tour.tags.home.domain.HomeTag;
import com.example.tour.tags.home.dto.HomeTagCreateRequest;
import com.example.tour.tags.home.dto.HomeTagUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class HomeTagsController {

    private final HomeTagsServiceImpl homeTagsService;

    @PostMapping("/api/tags/home")
    public void saveHomeTags(@RequestBody HomeTagCreateRequest request) {
        homeTagsService.saveHomeTags(request);
    }

    @GetMapping("/api/tags/home")
    public ResponseEntity<List<HomeTag>> getHomeTags() {
        return ResponseEntity.ok().body(homeTagsService.getHomeTags());
    }

    @PutMapping("/api/tags/home")
    public void updateHomeTags(@RequestBody HomeTagUpdateRequest request) {
        homeTagsService.updaterHomeTags(request);
    }

    @DeleteMapping("/api/tags/home")
    public void deleteHomeTags(@RequestParam Long id) {
        homeTagsService.deleteHomeTags(id);
    }
}
