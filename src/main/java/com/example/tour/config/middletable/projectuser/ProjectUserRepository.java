package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.id.ProjectUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, ProjectUserId> {
    List<ProjectUser> findProjectUsersByIdUserId(Long userId);

    List<ProjectUser> findProjectUsersByIdProjectId(Long projectId);

    ProjectUser findProjectUserByIdUserIdAndProjectId(Long projectId, Long userId);
}
