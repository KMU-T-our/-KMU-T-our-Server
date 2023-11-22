package com.example.tour.tags.schedule;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.config.middletable.tag.TagRepository;
import com.example.tour.config.middletable.tag.TagService;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import com.example.tour.tags.schedule.domain.ScheduleTag;
import com.example.tour.tags.schedule.dto.ScheduleTagCreateRequest;
import com.example.tour.tags.schedule.dto.ScheduleTagResponse;
import com.example.tour.tags.schedule.dto.ScheduleTagUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleTagServiceImpl {

    private final ScheduleTagRepository scheduleTagRepository;
    private final TagService tagService;
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public ScheduleTag saveScheduleTag(ScheduleTagCreateRequest request) {
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalAccessError::new);
        Tag tag = tagService.getInstance();
        ScheduleTag scheduleTag = new ScheduleTag(project, tag, request);
        scheduleTagRepository.save(scheduleTag);
        return scheduleTag;
    }

    @Transactional
    public ScheduleTagResponse findByTagId(Long tagId){
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalAccessError::new);
        return new ScheduleTagResponse(scheduleTagRepository.findByTag(tag));
    }

    @Transactional
    public ScheduleTagResponse findByDateAndProjectId(ScheduleTagCreateRequest request){
        Project project = projectRepository.findProjectById(request.getProjectId());
        ScheduleTag scheduleTag = scheduleTagRepository.findByDateAndProject(request.getDate(), project);
        return new ScheduleTagResponse(scheduleTag);
    }

    @Transactional
    public void updateScheduleTag(ScheduleTagUpdateRequest request){
        Tag tag = tagRepository.findById(request.getTagId())
                .orElseThrow(IllegalAccessError::new);
        ScheduleTag scheduleTag = scheduleTagRepository.findByTag(tag);
        scheduleTag.updateScheduleTag(request);
    }

    @Transactional
    public void deleteScheduleTag(Long tagId){
        Tag tag = tagRepository.findById(tagId)
                        .orElseThrow(IllegalAccessError::new);
        scheduleTagRepository.deleteByTag(tag);
    }

    public List<ScheduleTagResponse> findByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(IllegalArgumentException::new);
        return scheduleTagRepository.findByProject(project).stream()
                .map(ScheduleTagResponse::new)
                .toList();
    }

    public ScheduleTagResponse findByDate(String date) {
        ScheduleTag scheduleTag = scheduleTagRepository.findByDate(date);
        return new ScheduleTagResponse(scheduleTag);
    }
}
