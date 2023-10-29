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
    public void postProject(@RequestParam("project_name") String name, @RequestParam("user_id") Long userId) {
        projectService.saveProject(name, userId);
    }

    @GetMapping("/api/projects")
    public List<Project> getAllProject() {
        return projectService.getAllProject();
    }

    @GetMapping("/api/project")
    public List<Project> getProjectByUserId(@RequestParam Long id) {
        return projectService.getProjectByUserId(id);
    }

}
