package com.example.tour.user;

import com.example.tour.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    User findBySocialIdAndKakaoUser(String id);
    User findBySocialIdAndNaverUser(String id);
}
