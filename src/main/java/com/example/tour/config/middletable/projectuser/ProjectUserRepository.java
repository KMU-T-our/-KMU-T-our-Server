package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.id.ProjectUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, ProjectUserId> {
    List<ProjectUser> findProjectUsersByIdUserId(Long userId);

    List<ProjectUser> findProjectUsersByIdProjectId(Long projectId);
}
