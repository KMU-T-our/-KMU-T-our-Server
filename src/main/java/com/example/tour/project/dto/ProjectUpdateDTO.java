package com.example.tour.project.dto;

import com.example.tour.project.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectUpdateDTO {
    public Long projectId;
    public String name;
    public String startDay;
    public String endDay;

    public ProjectUpdateDTO(Project project) {
        this.projectId = project.getId();
        this.name = project.getName();
        this.startDay = project.getStartDay();
        this.endDay = project.getEndDay();
    }
}
