package com.example.tour.project;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/api/project")
    public void postProject(@RequestParam String name) {
        projectService.saveProject(new Project(name));
    }

    @GetMapping("/api/project")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }
}
