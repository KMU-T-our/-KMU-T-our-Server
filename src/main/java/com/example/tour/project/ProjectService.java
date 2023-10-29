package com.example.tour.project;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.user.UserRepository;
import com.example.tour.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectUserRepository projectUserRepository;
    private final UserRepository userRepository;


    public void saveProject(String name, Long userId) {
        Project project = new Project(name);
        User user = userRepository.findById(userId)
                .orElseThrow(IllegalArgumentException::new);
        ProjectUser projectUser = new ProjectUser(project, user);
        projectUserRepository.save(projectUser);
        projectRepository.save(project);
    }

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectByUserId(Long id) {
        return projectUserRepository.findByUserId(id)
                .stream()
                .map(ProjectUser::getProject)
                .toList();
    }
}
