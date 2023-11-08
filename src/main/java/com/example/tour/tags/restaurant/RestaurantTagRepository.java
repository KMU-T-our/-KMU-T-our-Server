package com.example.tour.tags.restaurant;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.restaurant.domain.RestaurantTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantTagRepository extends JpaRepository<RestaurantTag, Long> {
    RestaurantTag findByTag(Tag tag);

    void deleteByTag(Tag tag);

}
