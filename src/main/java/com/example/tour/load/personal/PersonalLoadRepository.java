package com.example.tour.load.personal;

import com.example.tour.load.personal.domain.PersonalLoad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalLoadRepository extends JpaRepository<PersonalLoad, Long> {
    Optional<PersonalLoad> findByName(String name);
}
