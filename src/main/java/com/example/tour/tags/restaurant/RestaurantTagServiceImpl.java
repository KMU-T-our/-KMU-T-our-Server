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
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantTagServiceImpl {

    private final RestaurantTagRepository restaurantTagRepository;
    private final TagService tagService;
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public void saveRestaurantTag(RestaurantTagCreateRequest request) {
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        Tag tag = tagService.getInstance();
        restaurantTagRepository.save(new RestaurantTag(project, tag, request));
    }

    @Transactional
    public RestaurantTagResponse findByTagId(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);
        return new RestaurantTagResponse(restaurantTagRepository.findByTag(tag));
    }

    @Transactional
    public void updaterRestaurantTags(RestaurantTagUpdateRequest request) {
        Tag tag = tagRepository.findById(request.getTagId())
                .orElseThrow(IllegalArgumentException::new);
        RestaurantTag restaurantTag = restaurantTagRepository.findByTag(tag);
        restaurantTag.update(request);
    }

    @Transactional
    public void deleteRestaurantTag(Long tagId) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(IllegalArgumentException::new);
        restaurantTagRepository.deleteByTag(tag);
    }
}
