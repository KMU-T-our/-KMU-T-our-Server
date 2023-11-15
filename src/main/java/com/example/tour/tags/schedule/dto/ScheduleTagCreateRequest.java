package com.example.tour.tags.schedule.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleTagCreateRequest {
    private Long projectId;
    private String name;
    private String date;
    private String content;
}
