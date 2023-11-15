package com.example.tour.tags.home;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.home.dto.HomeTagCreateRequest;
import com.example.tour.tags.home.dto.HomeTagResponse;
import com.example.tour.tags.home.dto.HomeTagUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class HomeTagsController {

    private final HomeTagsServiceImpl homeTagsService;

    // 숙소태그 등록
    @PostMapping("/api/tags/home")
    public Tag saveHomeTags(@RequestBody HomeTagCreateRequest request) {
        return homeTagsService.saveHomeTag(request);
    }

    // TagId로 숙소태그 검색
    @GetMapping("/api/tags/home")
    public HomeTagResponse getHomeTagByTagId(@RequestParam Long tagId) {
        return homeTagsService.findByTagId(tagId);
    }

    // projectID로 모든 숙소태그 찾기
    @GetMapping("/api/tags/homes")
    public List<HomeTagResponse> getHomeTagsByProjectId(@RequestParam Long projectId) {
        return homeTagsService.findByProjectId(projectId);
    }

    // 숙소태그 수정
    @PutMapping("/api/tags/home")
    public void updateHomeTags(@RequestBody HomeTagUpdateRequest request) {
        homeTagsService.updaterHomeTag(request);
    }

    // tagId로 숙소태그 삭제
    @DeleteMapping("/api/tags/home")
    public void deleteHomeTagByTagId(@RequestParam Long tagId) {
        homeTagsService.deleteHomeTag(tagId);
    }
}
