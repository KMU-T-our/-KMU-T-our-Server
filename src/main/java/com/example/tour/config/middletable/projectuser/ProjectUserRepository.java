package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserDto;
import com.example.tour.config.middletable.projectuser.id.ProjectUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, Long> {
}
