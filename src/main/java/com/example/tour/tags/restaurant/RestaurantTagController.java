package com.example.tour.tags.restaurant;

import com.example.tour.tags.restaurant.dto.RestaurantTagCreateRequest;
import com.example.tour.tags.restaurant.dto.RestaurantTagResponse;
import com.example.tour.tags.restaurant.dto.RestaurantTagUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class RestaurantTagController {

    private final RestaurantTagServiceImpl restaurantTagsService;

    // 맛집태그 등록
    @PostMapping("/api/tags/restaurant")
    public RestaurantTagResponse saveRestaurantTags(@RequestBody RestaurantTagCreateRequest request) {
        return restaurantTagsService.saveRestaurantTag(request);
    }

    // tagId로 맛집태그 검색
    @GetMapping("/api/tags/restaurant")
    public RestaurantTagResponse getRestaurantTags(@RequestParam Long tagId) {
        return restaurantTagsService.findByTagId(tagId);
    }

    // projectId로 맛집태그 검색
    @GetMapping("/api/tags/restaurants")
    public List<RestaurantTagResponse> getRestaurantTagsByProjectId(@RequestParam Long projectId) {
        return restaurantTagsService.findByProjectId(projectId);
    }

    // 맛집태그 수정
    @PatchMapping("/api/tags/restaurant")
    public RestaurantTagResponse updateRestaurantTags(@RequestBody RestaurantTagUpdateRequest request) {
        return restaurantTagsService.updaterRestaurantTags(request);
    }

    // 맛집태그 삭제
    @DeleteMapping("/api/tags/restaurant")
    public void deleteRestaurantTags(@RequestParam Long tagId) {
        restaurantTagsService.deleteRestaurantTag(tagId);
    }
}
