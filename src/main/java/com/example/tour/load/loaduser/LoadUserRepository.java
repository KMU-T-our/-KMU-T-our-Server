package com.example.tour.load.loaduser;

import com.example.tour.load.loaduser.domain.LoadUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadUserRepository extends JpaRepository<LoadUser, Long> {
    List<LoadUser> findByShareLoadId(Long shareLoadId);
}
