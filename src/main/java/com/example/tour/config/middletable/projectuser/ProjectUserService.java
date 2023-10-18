package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectUserService {

    private final ProjectUserRepository projectUserRepository;

    public void saveProjectUser(ProjectUserDto projectUserDto) {
        ProjectUser projectUser = new ProjectUser(projectUserDto);
        projectUserRepository.save(projectUser);
    }

    public List<ProjectUser> getAllProjectUser() {
        return projectUserRepository.findAll();
    }

    @Transactional
    public void deleteUserByProject(ProjectUserDto request) {
        ProjectUser projectUser = new ProjectUser(request);
        projectUserRepository.delete(projectUser);
    }
}
