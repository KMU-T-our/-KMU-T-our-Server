package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserDto;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import com.example.tour.user.UserRepository;
import com.example.tour.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectUserService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ProjectUserRepository projectUserRepository;

    public void saveProjectUser(ProjectUserDto projectUserDto) {
        ProjectUser projectUser = new ProjectUser(projectUserDto);
        projectUserRepository.save(projectUser);
    }

    public List<ProjectUser> getAllProjectUser() {
        return projectUserRepository.findAll();
    }
}
