package com.example.tour.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }
}
