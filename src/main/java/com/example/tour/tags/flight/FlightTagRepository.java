package com.example.tour.tags.flight;

import com.example.tour.tags.flight.domain.FlightTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightTagRepository extends JpaRepository<FlightTag, Long> {
}
