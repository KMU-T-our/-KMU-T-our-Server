package com.example.tour.load.shareloaduser;

import com.example.tour.load.shareloaduser.domain.ShareLoadUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareLoadUserRepository extends JpaRepository<ShareLoadUser, Long> {
    List<ShareLoadUser> findByShareLoadId(Long shareLoadId);
}
