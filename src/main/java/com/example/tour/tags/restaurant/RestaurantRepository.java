package com.example.tour.tags.restaurant;

import com.example.tour.tags.restaurant.domain.RestaurantTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantTags, Long> {
}
