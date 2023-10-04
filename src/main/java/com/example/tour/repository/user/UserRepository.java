package com.example.tour.repository.user;

import com.example.tour.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    User findBySocialIdAndIsKakaoUser(Long id, boolean kakao);

//    User findBySocialIdAndNaverUser(Long id);
}
