package com.example.tour.tags.schedule;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.schedule.domain.ScheduleTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleTagRepository extends JpaRepository<ScheduleTag, Long> {
    ScheduleTag findByTag(Tag tag);
    void deleteByTag(Tag tag);

    List<ScheduleTag> findByProject(Project project);

    ScheduleTag findByDateAndProject(String date, Project project);
}
