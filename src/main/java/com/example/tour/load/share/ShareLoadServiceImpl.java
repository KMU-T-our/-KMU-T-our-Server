package com.example.tour.load.share;


import com.example.tour.load.share.domain.ShareLoad;
import com.example.tour.load.share.dto.ShareLoadResponse;
import com.example.tour.load.share.dto.ShareLoadSaveRequest;
import com.example.tour.load.share.dto.ShareLoadRequest;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShareLoadServiceImpl {

    private final ShareLoadRepository shareLoadRepository;
    private final ProjectRepository projectRepository;


    @Transactional
    public void saveShareLoad(ShareLoadSaveRequest request) {
        Optional<Project> project = projectRepository.findById(request.getProjectId());
        ShareLoad shareLoad = new ShareLoad(request, project);
        shareLoadRepository.save(shareLoad);

    }

    // 전체 검색
    @Transactional
    public List<ShareLoad> getAllShareLoad(ShareLoadRequest request) {
        Project project = projectRepository.findProjectById(request.getProjectId());
        return shareLoadRepository.findAllByProject(project);
    }

    // projectId + Id 로 검색
    @Transactional
    public ShareLoadResponse getShareLoad(ShareLoadRequest request){
        Project project = projectRepository.findProjectById(request.getProjectId());
        ShareLoad shareLoad = shareLoadRepository.findByProjectAndId(project, request.getId());
        ShareLoadResponse shareLoadResponse = new ShareLoadResponse(shareLoad);
        return shareLoadResponse;
    }

    @Transactional
    public void updaterShareLoad(ShareLoadRequest request) {
        ShareLoad shareLoad = shareLoadRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);
        shareLoad.updateShareLoad(request);
    }

    @Transactional
    public void deleteShareLoad(Long id){
        ShareLoad shareLoad = shareLoadRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);
        shareLoadRepository.delete(shareLoad);
    }
}
