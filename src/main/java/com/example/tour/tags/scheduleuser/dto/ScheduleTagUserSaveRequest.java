package com.example.tour.tags.scheduleuser.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScheduleTagUserSaveRequest {
    Long scheduleTagId;
    List<Long> users;
}
