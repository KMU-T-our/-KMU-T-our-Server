package com.example.tour.user.dto;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import lombok.Data;

@Data
public class UserResponse {
    Long userId;
    Long projectUserId;
    String identity;

    public UserResponse(ProjectUser projectUser) {
        this.userId = projectUser.getUser().getId();
        this.projectUserId = projectUser.getProjectUserId();
        this.identity = projectUser.getUser().getIdentity();
    }
}
