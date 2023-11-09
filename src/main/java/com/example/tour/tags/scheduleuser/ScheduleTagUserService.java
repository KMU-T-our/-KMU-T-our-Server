package com.example.tour.tags.scheduleuser;

import com.example.tour.tags.schedule.ScheduleTagRepository;
import com.example.tour.tags.schedule.domain.ScheduleTag;
import com.example.tour.tags.scheduleuser.domain.ScheduleTagUser;
import com.example.tour.tags.scheduleuser.dto.ScheduleTagUserSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleTagUserService {

    private final ScheduleTagUserRepository scheduleTagUserRepository;
    private final ScheduleTagRepository scheduleTagRepository;

    @Transactional
    public void save(ScheduleTagUserSaveRequest request){
        ScheduleTag scheduleTag = scheduleTagRepository.findById(request.getScheduleUserId())
                .orElseThrow(IllegalAccessError::new);
        request.getUsers().stream()
                .forEach(v -> scheduleTagUserRepository.save(new ScheduleTagUser(scheduleTag, v)));
    }

    public List<Long> get(Long scheduleUserId){
        return scheduleTagUserRepository.findByScheduleTagId(scheduleUserId).stream()
                .map(ScheduleTagUser::getUserId)
                .toList();
    }
}
