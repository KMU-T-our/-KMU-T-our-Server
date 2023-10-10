package com.example.tour.tags.restaurant;

import com.example.tour.tags.restaurant.domain.RestaurantTags;
import com.example.tour.tags.restaurant.dto.RestaurantTagsCreateRequest;
import com.example.tour.tags.restaurant.dto.RestaurantTagsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantTagsServiceImpl {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void saveRestaurantTags(RestaurantTagsCreateRequest request) {
        RestaurantTags r = restaurantRepository.save(new RestaurantTags(request));
    }

    @Transactional
    public List<RestaurantTags> getRestaurantTags() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public void updaterRestaurantTags(RestaurantTagsUpdateRequest request) {
        RestaurantTags restaurantTags = restaurantRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        restaurantTags.updateRestaurantTags(request);
    }

    @Transactional
    public void deleteRestaurantTags(Long id) {
        RestaurantTags restaurantTags = restaurantRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        restaurantRepository.delete(restaurantTags);
    }
}
