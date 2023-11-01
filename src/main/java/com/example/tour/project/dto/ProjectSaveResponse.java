package com.example.tour.project.dto;

import com.example.tour.project.Project;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectSaveResponse {
    public Long projectId;
    public Long projectUserId;
    public String projectName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date startDay;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date endDay;

    public ProjectSaveResponse(Long projectUserId, Project project) {
        this.projectUserId = projectUserId;
        this.projectId = project.getId();
        this.projectName = project.getName();
        this.startDay = project.getStartDay();
        this.endDay = project.getEndDay();
    }
}
