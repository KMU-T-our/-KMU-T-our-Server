package com.example.tour.tags.flight;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.config.middletable.tag.TagRepository;
import com.example.tour.config.middletable.tag.TagService;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import com.example.tour.tags.flight.domain.FlightTag;
import com.example.tour.tags.flight.dto.FlightTagCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagResponse;
import com.example.tour.tags.flight.dto.FlightTagUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightTagService {

    private final FlightTagRepository flightTagRepository;
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;
    private final TagService tagService;

    @Transactional
    public Tag saveFlightTag(FlightTagCreateRequest request) {
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        Tag tag = tagService.getInstance();
        flightTagRepository.save(new FlightTag(project, tag, request));
        return tag;

    }

    @Transactional
    public FlightTagResponse findByTagId(Long tagId){
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);
        return new FlightTagResponse(flightTagRepository.findByTag(tag));
    }

    @Transactional
    public void updateFlightTag(FlightTagUpdateRequest request) {
        Tag tag = tagRepository.findById(request.getTagId())
                .orElseThrow(IllegalArgumentException::new);
        FlightTag flightTag = flightTagRepository.findByTag(tag);
        flightTag.updateFlightTag(request);
    }

    @Transactional
    public void deleteFlightTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalArgumentException::new);
        flightTagRepository.deleteByTag(tag);
    }
}
