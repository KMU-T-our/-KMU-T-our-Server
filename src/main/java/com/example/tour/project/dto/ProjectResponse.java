package com.example.tour.project.dto;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponse {
    public Long projectId;
    public Long projectUserId;
    public String projectName;
    public String startDay;
    public String endDay;

    public ProjectResponse(ProjectUser projectUser) {
        this.projectUserId = projectUser.getProjectUserId();
        this.projectId = projectUser.getProject().getId();
        this.projectName = projectUser.getProject().getName();
        this.startDay = projectUser.getProject().getStartDay();
        this.endDay = projectUser.getProject().getEndDay();
    }
}
