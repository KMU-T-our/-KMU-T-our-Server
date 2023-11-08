package com.example.tour.tags.home;

import com.example.tour.tags.home.domain.HomeTag;
import com.example.tour.tags.home.dto.HomeTagCreateRequest;
import com.example.tour.tags.home.dto.HomeTagUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HomeTagsServiceImpl {

    private final HomeTagsRepository homeTagsRepository;

    @Transactional
    public void saveHomeTags(HomeTagCreateRequest request) {
        HomeTag h = homeTagsRepository.save(new HomeTag(request));
    }

    @Transactional
    public List<HomeTag> getHomeTags() {
        return homeTagsRepository.findAll();
    }

    @Transactional
    public void updaterHomeTags(HomeTagUpdateRequest request) {
        HomeTag homeTag = homeTagsRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        homeTag.updateHomeTags(request);
    }

    @Transactional
    public void deleteHomeTags(Long id) {
        HomeTag homeTag = homeTagsRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        homeTagsRepository.delete(homeTag);
    }
}

