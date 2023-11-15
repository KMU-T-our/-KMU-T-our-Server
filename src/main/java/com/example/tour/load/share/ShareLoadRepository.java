package com.example.tour.load.share;

import com.example.tour.load.share.domain.ShareLoad;
import com.example.tour.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShareLoadRepository extends JpaRepository<ShareLoad, Long> {
    List<ShareLoad> findAllByProject(Project project);

    ShareLoad findByProjectAndId(Project project, Long id);
}
