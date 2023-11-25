package com.example.tour.tags.schedule.dto;

import com.example.tour.config.ResponseComparator;
import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.schedule.domain.ScheduleTag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleTagResponse implements ResponseComparator {
    private Long tagId;
    private String tagType = "schedule";
    private String name;
    private String date;
    private String content;

    public ScheduleTagResponse(ScheduleTag tag){
        this.tagId = tag.getTag().getTagId();
        this.name = tag.getName();
        this.date = tag.getDate();
        this.content = tag.getContent();
    }

}
