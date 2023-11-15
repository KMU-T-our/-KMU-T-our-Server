package com.example.tour.tags.home;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.home.domain.HomeTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeTagsRepository extends JpaRepository<HomeTag, Long> {
    HomeTag findByTag(Tag tag);
    void deleteByTag(Tag tag);

    List<HomeTag> findByProject(Project project);
}
