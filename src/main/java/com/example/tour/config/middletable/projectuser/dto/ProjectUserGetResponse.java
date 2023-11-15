package com.example.tour.config.middletable.projectuser.dto;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectUserGetResponse {
    public Long projectUserId;
    public User user;


    public ProjectUserGetResponse(ProjectUser projectUser) {
        this.projectUserId = projectUser.getProjectUserId();
        this.user = projectUser.getUser();
    }
}
