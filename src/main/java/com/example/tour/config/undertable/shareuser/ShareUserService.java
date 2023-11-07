package com.example.tour.config.undertable.shareuser;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.load.share.ShareLoadRepository;
import com.example.tour.load.share.domain.ShareLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShareUserService {

    private final ShareUserRepository shareUserRepository;
    private final ProjectUserRepository projectUserRepository;
    private final ShareLoadRepository shareLoadRepository;

    @Transactional
    public void makeShareUser(Long projectId, Long shareLoadId){
        List<ProjectUser> projectUsers = projectUserRepository.findAllByProjectId(projectId);
        Optional<ShareLoad> shareLoad = shareLoadRepository.findById(shareLoadId);

        for(ProjectUser projectUser: projectUsers){
            ShareUser shareUser = ShareUser.builder()
                    .shareLoad(shareLoad.get())
                    .userId(projectUser.getUser().getId())
                    .build();

            shareUserRepository.save(shareUser);
        }
    }

    /*
    @Transactional
    public List<ShareUser> getShareUser(){

    }
*/
}
