package com.example.tour.tags.home;

import com.example.tour.tags.home.domain.HomeTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeTagsRepository extends JpaRepository<HomeTags,Long> {
}
