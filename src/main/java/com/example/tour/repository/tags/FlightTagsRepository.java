package com.example.tour.repository.tags;

import com.example.tour.domain.tags.FlightTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightTagsRepository extends JpaRepository<FlightTags, Long> {
}
