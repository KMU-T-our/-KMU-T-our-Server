package com.example.tour.tags.schedule;

import com.example.tour.tags.schedule.domain.ScheduleTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleTagRepository extends JpaRepository<ScheduleTag, Long> {
}
