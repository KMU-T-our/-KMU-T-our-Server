package com.example.tour.tags.home;

import com.example.tour.tags.home.domain.HomeTags;
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
    public void saveHomeTags(HomeTagsCreateRequest request){
        HomeTags h = homeTagsRepository.save(new HomeTags((request)));
    }

    @Transactional
    public List<HomeTags> getHomeTags(){return homeTagsRepository.findAll();}

    @Transactional
    public void updaterHomeTags(HomeTagsUpdateRequest request){
        HomeTags homeTags = homeTagsRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        homeTags.updateHomeTags(request);
    }

    @Transactional
    public void deleteHomeTags(Long id){
        HomeTags homeTags = homeTagsRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        homeTagsRepository.delete(homeTags);
    }
}

