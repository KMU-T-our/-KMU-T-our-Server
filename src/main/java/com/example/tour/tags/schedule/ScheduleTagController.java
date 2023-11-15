package com.example.tour.tags.schedule;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.schedule.domain.ScheduleTag;
import com.example.tour.tags.schedule.dto.ScheduleTagCreateRequest;
import com.example.tour.tags.schedule.dto.ScheduleTagResponse;
import com.example.tour.tags.schedule.dto.ScheduleTagUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ScheduleTagController {

    private final ScheduleTagServiceImpl scheduleTagService;

    @PostMapping("/api/tags/schedule")
    public Tag saveSchedule(@RequestBody ScheduleTagCreateRequest request) {
        return scheduleTagService.saveScheduleTag(request);
    }

    @GetMapping("/api/tags/schedule")
    public ScheduleTagResponse getScheduleTag(@RequestParam Long tagId) {
        return scheduleTagService.findByTagId(tagId);
    }

    @PutMapping("/api/tags/schedule")
    public void updateScheduleTag(@RequestBody ScheduleTagUpdateRequest request){
        scheduleTagService.updateScheduleTag(request);
    }

    @DeleteMapping("/api/tags/schedule")
    public void deleteScheduleTag(@RequestParam Long tagId){
        scheduleTagService.deleteScheduleTag(tagId);
    }

    @GetMapping("/api/tags/schedules")
    public List<ScheduleTagResponse> getScheduleTagsByProjectId(@RequestParam Long projectId) {
        return scheduleTagService.findByProjectId(projectId);
    }

}
