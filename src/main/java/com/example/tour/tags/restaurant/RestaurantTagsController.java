package com.example.tour.tags.restaurant;

import com.example.tour.tags.restaurant.domain.RestaurantTags;
import com.example.tour.tags.restaurant.dto.RestaurantTagsCreateRequest;
import com.example.tour.tags.restaurant.dto.RestaurantTagsUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class RestaurantTagsController {

    private final RestaurantTagsServiceImpl restaurantTagsService;

    @PostMapping("/api/tags/restaurant")
    public void saveRestaurantTags(@RequestBody RestaurantTagsCreateRequest request) {
        restaurantTagsService.saveRestaurantTags(request);
    }

    @GetMapping("/api/tags/restaurant")
    public ResponseEntity<List<RestaurantTags>> getRestaurantTags() {
        return ResponseEntity.ok().body(restaurantTagsService.getRestaurantTags());
    }

    @PutMapping("/api/tags/restaurant")
    public void updateRestaurantTags(@RequestBody RestaurantTagsUpdateRequest request) {
        restaurantTagsService.updaterRestaurantTags(request);
    }

    @DeleteMapping("/api/tags/restaurant")
    public void deleteRestaurantTags(@RequestParam Long id) {
        restaurantTagsService.deleteRestaurantTags(id);
    }
}
