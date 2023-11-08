package com.example.tour.tags.schedule;

import com.example.tour.tags.schedule.domain.ScheduleTag;
import com.example.tour.tags.schedule.dto.ScheduleTagRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleTagServiceImpl {

    private final ScheduleTagRepository scheduleTagRepository;

    @Transactional
    public void saveScheduleTag(ScheduleTagRequest request){
        scheduleTagRepository.save(new ScheduleTag(request));
    }

    @Transactional
    public List<ScheduleTag> getScheduleTag(){
        return scheduleTagRepository.findAll();
    }

    @Transactional
    public void updateScheduleTag(ScheduleTagRequest request){
        ScheduleTag scheduleTag = scheduleTagRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);
        scheduleTag.updateScheduleTag(request);
    }

    @Transactional
    public void deleteScheduleTag(Long id){
        ScheduleTag scheduleTag = scheduleTagRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);
        scheduleTagRepository.delete(scheduleTag);
    }
}
