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

import java.util.IllformedLocaleException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FlightTagService {

    private final FlightTagRepository flightTagRepository;
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;
    private final TagService tagService;

    @Transactional
    public FlightTagResponse saveFlightTag(FlightTagCreateRequest request) {
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        Tag tag = tagService.getInstance();
        FlightTag savedFlightTag = flightTagRepository.save(new FlightTag(project, tag, request));
        return new FlightTagResponse(savedFlightTag);
    }

    @Transactional
    public FlightTagResponse findByTagId(Long tagId){
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);
        return new FlightTagResponse(flightTagRepository.findByTag(tag));
    }

    @Transactional
    public FlightTagResponse updateFlightTag(FlightTagUpdateRequest request) {
        Tag tag = tagRepository.findById(request.getTagId())
                .orElseThrow(IllegalArgumentException::new);
        FlightTag flightTag = flightTagRepository.findByTag(tag);
        flightTag.updateFlightTag(request);
        return new FlightTagResponse(flightTag);
    }

    @Transactional
    public void deleteFlightTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalArgumentException::new);
        flightTagRepository.deleteByTag(tag);
    }

    @Transactional
    public List<FlightTagResponse> findByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(IllegalArgumentException::new);
        return flightTagRepository.findByProject(project).stream()
                .map(FlightTagResponse::new)
                .toList();
    }
}
