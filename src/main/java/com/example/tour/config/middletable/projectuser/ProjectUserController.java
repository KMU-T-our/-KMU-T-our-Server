package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserGetResponse;
import com.example.tour.config.middletable.projectuser.dto.ProjectUserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectUserController {
    private final ProjectUserService projectUserService;

    @PostMapping("/api/projectuser")
    public String saveProjectUser(@RequestBody ProjectUserSaveRequest request) {
        return projectUserService.save(request);
    }

    @GetMapping("/api/projectuser/byprojectuserid")
    public List<ProjectUserGetResponse> getProejctUserList(@RequestParam Long projectUserId){
        return projectUserService.findUserByProjectUserId(projectUserId);
    }

    @DeleteMapping("/api/proejectuser")
    public void deleteProjectUser(@RequestParam Long projectUserId){
        projectUserService.deleteProjectUser(projectUserId);
    }
}
