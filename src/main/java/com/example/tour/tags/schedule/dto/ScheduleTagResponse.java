package com.example.tour.tags.schedule.dto;

import com.example.tour.tags.schedule.domain.ScheduleTag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleTagResponse {
    private Long tagId;
    private String scheduleName;
    private String scheduleDate;
    private String scheduleContent;

    public ScheduleTagResponse(ScheduleTag tag){
        this.tagId = tag.getTag().getTagId();
        this.scheduleName = tag.getScheduleName();
        this.scheduleDate = tag.getScheduleDate();
        this.scheduleContent = tag.getScheduleContent();
    }
}
