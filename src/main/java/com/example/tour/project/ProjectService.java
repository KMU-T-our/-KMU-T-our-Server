package com.example.tour.project;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectUserRepository projectUserRepository;
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectByUserId(Long id) {
        return projectUserRepository.findProjectUsersByIdUserId(id)
                .stream()
                .map(ProjectUser::getProject)
                .toList();
    }
}
