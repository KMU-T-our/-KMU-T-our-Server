package com.example.tour.tags.restaurant;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.restaurant.dto.RestaurantTagCreateRequest;
import com.example.tour.tags.restaurant.dto.RestaurantTagResponse;
import com.example.tour.tags.restaurant.dto.RestaurantTagUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class RestaurantTagController {

    private final RestaurantTagServiceImpl restaurantTagsService;

    @PostMapping("/api/tags/restaurant")
    public Tag saveRestaurantTags(@RequestBody RestaurantTagCreateRequest request) {
        return restaurantTagsService.saveRestaurantTag(request);
    }

    @GetMapping("/api/tags/restaurant")
    public RestaurantTagResponse getRestaurantTags(@RequestParam Long tagId) {
        return restaurantTagsService.findByTagId(tagId);
    }

    @PutMapping("/api/tags/restaurant")
    public void updateRestaurantTags(@RequestBody RestaurantTagUpdateRequest request) {
        restaurantTagsService.updaterRestaurantTags(request);
    }

    @DeleteMapping("/api/tags/restaurant")
    public void deleteRestaurantTags(@RequestParam Long tagId) {
        restaurantTagsService.deleteRestaurantTag(tagId);
    }
}
