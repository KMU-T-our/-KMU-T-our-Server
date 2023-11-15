package com.example.tour.tags.schedule.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleTagCreateRequest {
    private String scheduleName;
    private String scheduleDate;
    private String scheduleContent;
    private Long projectId;
}
