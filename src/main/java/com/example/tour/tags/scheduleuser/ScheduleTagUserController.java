package com.example.tour.tags.scheduleuser;

import com.example.tour.tags.scheduleuser.dto.ScheduleTagUserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleTagUserController {

    private final ScheduleTagUserService scheduleTagUserService;

    @PostMapping("/api/scheduleuser")
    public void saveScheduleTagUser(@RequestBody ScheduleTagUserSaveRequest request){
        scheduleTagUserService.save(request);
    }

    @GetMapping("/api/scheduleuser")
    public List<Long> get(@RequestParam Long scheduleUserId){
        return scheduleTagUserService.get(scheduleUserId);
    }
}
