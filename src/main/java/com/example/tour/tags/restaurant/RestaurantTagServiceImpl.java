package com.example.tour.tags.restaurant;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.config.middletable.tag.TagRepository;
import com.example.tour.config.middletable.tag.TagService;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import com.example.tour.tags.restaurant.domain.RestaurantTag;
import com.example.tour.tags.restaurant.dto.RestaurantTagCreateRequest;
import com.example.tour.tags.restaurant.dto.RestaurantTagResponse;
import com.example.tour.tags.restaurant.dto.RestaurantTagUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RestaurantTagServiceImpl {

    private final RestaurantTagRepository restaurantTagRepository;
    private final TagService tagService;
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public RestaurantTagResponse saveRestaurantTag(RestaurantTagCreateRequest request) {
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        log.info("numberOfPeople = {}", request.getNumberOfPeople());
        Tag tag = tagService.getInstance();
        RestaurantTag savedTag = restaurantTagRepository.save(new RestaurantTag(project, tag, request));
        return new RestaurantTagResponse(savedTag);
    }

    @Transactional
    public RestaurantTagResponse findByTagId(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);
        return new RestaurantTagResponse(restaurantTagRepository.findByTag(tag));
    }

    @Transactional
    public RestaurantTagResponse updaterRestaurantTags(RestaurantTagUpdateRequest request) {
        Tag tag = tagRepository.findById(request.getTagId())
                .orElseThrow(IllegalArgumentException::new);
        RestaurantTag restaurantTag = restaurantTagRepository.findByTag(tag);
        restaurantTag.update(request);
        return new RestaurantTagResponse(restaurantTag);
    }

    @Transactional
    public void deleteRestaurantTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);
        restaurantTagRepository.deleteByTag(tag);
    }

    @Transactional
    public List<RestaurantTagResponse> findByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(IllegalArgumentException::new);
        return restaurantTagRepository.findByProject(project).stream()
                .map(RestaurantTagResponse::new)
                .toList();
    }
}
