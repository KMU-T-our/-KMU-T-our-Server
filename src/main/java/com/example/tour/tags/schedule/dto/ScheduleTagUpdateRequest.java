package com.example.tour.tags.schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleTagUpdateRequest {
    private Long tagId;
    private String name;
    private String date;
    private String content;
}
