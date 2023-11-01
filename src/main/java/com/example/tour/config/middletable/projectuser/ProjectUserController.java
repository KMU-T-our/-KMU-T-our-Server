package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserResponse;
import com.example.tour.config.middletable.projectuser.dto.ProjectUserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectUserController {
    private final ProjectUserService projectUserService;

    @PostMapping("/api/projectuser")
    public ProjectUserResponse saveProjectUser(@RequestBody ProjectUserSaveRequest request) {
        return projectUserService.save(request);
    }
}
