package com.example.tour.project;

import com.example.tour.project.dto.ProjectResponse;
import com.example.tour.project.dto.ProjectSaveRequest;
import com.example.tour.project.dto.ProjectSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/api/project")
    public ProjectSaveResponse saveProject(@RequestBody ProjectSaveRequest request) {
        return projectService.saveProject(request);
    }

    @GetMapping("/api/project")
    public List<ProjectResponse> getProjectByUserId(@RequestParam Long userId) {
        return projectService.getProjectByUserId(userId);
    }
}
