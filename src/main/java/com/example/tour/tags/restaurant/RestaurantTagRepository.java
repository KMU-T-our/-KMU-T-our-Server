package com.example.tour.tags.restaurant;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.restaurant.domain.RestaurantTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantTagRepository extends JpaRepository<RestaurantTag, Long> {
    RestaurantTag findByTag(Tag tag);

    void deleteByTag(Tag tag);

    List<RestaurantTag> findByProject(Project project);
}
