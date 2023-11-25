package com.example.tour.project;

import com.example.tour.project.dto.ProjectResponse;
import com.example.tour.project.dto.ProjectSaveRequest;
import com.example.tour.project.dto.ProjectSaveResponse;
import com.example.tour.project.dto.ProjectUpdateDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/api/project/tags")
    public ResponseEntity<List<Object>> getTags(@RequestParam Long projectId) throws JsonProcessingException {
        return ResponseEntity.ok().body(projectService.getTags(projectId));
    }

    @GetMapping("/api/project/three/tags")
    public ResponseEntity<List<Object>> getThreeTags(@RequestParam Long projectId) throws JsonProcessingException{
        return ResponseEntity.ok().body(projectService.getThreeTags(projectId));
    }

    @PatchMapping("/api/project")
    public ProjectUpdateDTO updateProject(@RequestBody ProjectUpdateDTO request) {
        return projectService.updateProject(request);
    }
}
