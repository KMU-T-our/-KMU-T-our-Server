package com.example.tour.project.dto;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.project.Project;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectResponse {
    public Long projectId;
    public Long projectUserId;
    public String projectName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date startDay;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date endDay;

    public ProjectResponse(ProjectUser projectUser) {
        this.projectUserId = projectUser.getProjectUserId();
        this.projectId = projectUser.getProject().getId();
        this.projectName = projectUser.getProject().getName();
        this.startDay = projectUser.getProject().getStartDay();
        this.endDay = projectUser.getProject().getEndDay();
    }
}
