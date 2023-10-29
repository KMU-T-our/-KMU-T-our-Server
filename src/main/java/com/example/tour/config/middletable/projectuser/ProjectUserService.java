package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserDto;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import com.example.tour.user.UserRepository;
import com.example.tour.user.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectUserService {

    private final ProjectUserRepository projectUserRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveProjectUser(ProjectUserDto request) {
        ProjectUser projectUser = makeProjectUser(request);
        projectUserRepository.save(projectUser);
    }

    public List<ProjectUser> getAllProjectUser() {
        return projectUserRepository.findAll();
    }

    @Transactional
    public void deleteUserByProject(ProjectUserDto request) {
        ProjectUser projectUser = makeProjectUser(request);
        projectUserRepository.delete(projectUser);
    }


    private ProjectUser makeProjectUser(ProjectUserDto request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        return new ProjectUser(project, user);
    }
}
