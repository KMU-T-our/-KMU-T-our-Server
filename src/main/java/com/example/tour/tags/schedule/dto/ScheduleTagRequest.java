package com.example.tour.tags.schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleTagRequest {
    private Long id;
    private String scheduleName;
    private String scheduleDate;
    private String scheduleContent;
}
