package com.example.tour.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectSaveRequest {
    public Long userId;
    public String projectName;
    public String startDay;
    public String endDay;
}
