package com.example.tour.tags.home;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.config.middletable.tag.TagRepository;
import com.example.tour.config.middletable.tag.TagService;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import com.example.tour.tags.home.domain.HomeTag;
import com.example.tour.tags.home.dto.HomeTagCreateRequest;
import com.example.tour.tags.home.dto.HomeTagResponse;
import com.example.tour.tags.home.dto.HomeTagUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HomeTagsServiceImpl {

    private final HomeTagsRepository homeTagsRepository;
    private final TagService tagService;
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public Tag saveHomeTag(HomeTagCreateRequest request) {
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        Tag tag = tagService.getInstance();
        HomeTag homeTag = homeTagsRepository.save(new HomeTag(project, tag, request));
        return tag;
    }

    @Transactional
    public HomeTagResponse findByTagId(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);
        return new HomeTagResponse(homeTagsRepository.findByTag(tag));
    }

    @Transactional
    public void updaterHomeTag(HomeTagUpdateRequest request) {
        Tag tag = tagRepository.findById(request.getTagId())
                .orElseThrow(IllegalArgumentException::new);
        HomeTag homeTag = homeTagsRepository.findByTag(tag);
        homeTag.update(request);

    }

    @Transactional
    public void deleteHomeTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);
        homeTagsRepository.deleteByTag(tag);
    }
}

