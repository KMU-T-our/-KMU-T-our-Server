package com.example.tour.load.share;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.config.undertable.shareuser.ShareUserRepository;
import com.example.tour.config.undertable.shareuser.ShareUserService;
import com.example.tour.load.share.domain.ShareLoad;
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

    private final ShareUserService shareUserService;
    @Transactional
    public void saveShareLoad(ShareLoadRequest request){
        Optional<Project> project = projectRepository.findById(request.getProject_id());
        ShareLoad shareLoad = new ShareLoad(request, project);
        shareLoadRepository.save(shareLoad);

        //shareUser 테이블에 값 넣기(디폴트값 : 프로젝트 Id 일치하는 유저 정보 삽입)
        shareUserService.makeShareUser(request.getProject_id(), shareLoad.getId());
    }

    // 전체 검색
    @Transactional
    public List<ShareLoad> getShareLoad(){
        return shareLoadRepository.findAll();
    }

    @Transactional
    public void updaterShareLoad(ShareLoadRequest request){
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
