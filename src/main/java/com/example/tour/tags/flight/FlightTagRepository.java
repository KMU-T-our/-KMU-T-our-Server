package com.example.tour.tags.flight;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.flight.domain.FlightTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightTagRepository extends JpaRepository<FlightTag, Long> {
    List<FlightTag> findByProject(Project project);
    FlightTag findByTag(Tag tag);
    void deleteByTag(Tag tag);
}
