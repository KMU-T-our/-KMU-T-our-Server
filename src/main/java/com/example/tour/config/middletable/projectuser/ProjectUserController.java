package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectUserController {

    private final ProjectUserService projectUserService;

    @GetMapping("/api/projectuser")
    public List<ProjectUser> getProjectUser() {
        return projectUserService.getAllProjectUser();
    }

    @PostMapping("/api/projectuser")
    public void saveProjectUser(@RequestBody ProjectUserDto projectUserDto) {
        projectUserService.saveProjectUser(projectUserDto);
    }

}
