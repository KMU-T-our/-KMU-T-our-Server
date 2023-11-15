package com.example.tour.load.shareloaduser;

import com.example.tour.load.shareloaduser.domain.ShareLoadUser;
import com.example.tour.load.shareloaduser.dto.ShareLoadUserSaveRequest;
import com.example.tour.load.share.ShareLoadRepository;
import com.example.tour.load.share.domain.ShareLoad;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShareLoadUserService {

    private final ShareLoadUserRepository shareLoadUserRepository;
    private final ShareLoadRepository shareLoadRepository;

    @Transactional
    public void save(ShareLoadUserSaveRequest request) {
        ShareLoad shareLoad = shareLoadRepository.findById(request.getLoadId())
                .orElseThrow(IllegalArgumentException::new);
        request.getUsers().stream()
                .forEach(v -> shareLoadUserRepository.save(new ShareLoadUser(shareLoad, v)));
    }

    public List<Long> get(Long loadId) {
        return shareLoadUserRepository.findByShareLoadId(loadId).stream()
                .map(ShareLoadUser::getUserId)
                .toList();
    }

    public void delete(Long loadId){
        ShareLoadUser shareLoadUser = shareLoadUserRepository.findById(loadId)
                .orElseThrow(IllegalAccessError::new);
        shareLoadUserRepository.delete(shareLoadUser);
    }
}