package com.example.tour.tags.schedule;

import com.example.tour.tags.schedule.domain.ScheduleTag;
import com.example.tour.tags.schedule.dto.ScheduleTagRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ScheduleTagController {

    private final ScheduleTagServiceImpl scheduleTagService;

    @PostMapping("/api/tags/schedule")
    public void saveSchedule(@RequestBody ScheduleTagRequest request){
        scheduleTagService.saveScheduleTag(request);
    }

    @GetMapping("/api/tags/schedule")
    public ResponseEntity<List<ScheduleTag>> getScheduleTag(){
        return ResponseEntity.ok()
                .body(scheduleTagService.getScheduleTag());
    }

    @PutMapping("/api/tags/schedule")
    public void updateScheduleTag(@RequestBody ScheduleTagRequest request){
        scheduleTagService.updateScheduleTag(request);
    }

    @DeleteMapping("/api/tags/schedule")
    public void deleteScheduleTag(@RequestParam Long id){
        scheduleTagService.deleteScheduleTag(id);
    }


}
