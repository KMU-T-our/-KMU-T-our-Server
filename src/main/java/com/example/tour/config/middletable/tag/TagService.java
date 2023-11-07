package com.example.tour.config.middletable.tag;

import com.example.tour.config.middletable.tag.dto.TagResponse;
import com.example.tour.config.middletable.tag.dto.TagSaveRequest;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public TagResponse save(TagSaveRequest request){
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        Tag tag = tagRepository.save(new Tag(project));
        return new TagResponse(tag.getId());
    }
}
