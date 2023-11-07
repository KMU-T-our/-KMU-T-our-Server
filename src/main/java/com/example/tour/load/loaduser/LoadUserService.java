package com.example.tour.load.loaduser;

import com.example.tour.load.loaduser.domain.LoadUser;
import com.example.tour.load.loaduser.dto.LoadUserSaveRequest;
import com.example.tour.load.share.ShareLoadRepository;
import com.example.tour.load.share.domain.ShareLoad;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoadUserService {

    private final LoadUserRepository loadUserRepository;
    private final ShareLoadRepository shareLoadRepository;

    @Transactional
    public void save(LoadUserSaveRequest request) {
        ShareLoad shareLoad = shareLoadRepository.findById(request.getLoadId())
                .orElseThrow(IllegalArgumentException::new);
        request.getUsers().stream()
                .forEach(v -> loadUserRepository.save(new LoadUser(shareLoad, v)));
    }

    public List<Long> get(Long loadId) {
        return loadUserRepository.findByShareLoadId(loadId).stream()
                .map(LoadUser::getUserId)
                .toList();
    }
}