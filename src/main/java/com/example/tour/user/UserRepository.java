
package com.example.tour.user;

import com.example.tour.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findBySocialIdAndType(String id, String type);

    Optional<User> findByIdentity(String identity);
    
}
