package com.example.tour.tags.home;

import com.example.tour.tags.home.domain.HomeTag;
import com.example.tour.tags.home.dto.HomeTagsCreateRequest;
import com.example.tour.tags.home.dto.HomeTagsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HomeTagsServiceImpl {

    private final HomeTagsRepository homeTagsRepository;

    @Transactional
    public void saveHomeTags(HomeTagsCreateRequest request) {
        HomeTag h = homeTagsRepository.save(new HomeTag((request)));
    }

    @Transactional
    public List<HomeTag> getHomeTags() {
        return homeTagsRepository.findAll();
    }

    @Transactional
    public void updaterHomeTags(HomeTagsUpdateRequest request) {
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

