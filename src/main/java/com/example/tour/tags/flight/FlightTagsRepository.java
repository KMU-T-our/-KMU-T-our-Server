package com.example.tour.tags.flight;

import com.example.tour.tags.flight.domain.FlightTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightTagsRepository extends JpaRepository<FlightTags, Long> {
}
