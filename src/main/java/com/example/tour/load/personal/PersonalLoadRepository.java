package com.example.tour.load.personal;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.load.personal.domain.PersonalLoad;
import com.example.tour.load.personal.dto.PersonalLoadResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalLoadRepository extends JpaRepository<PersonalLoad, Long> {
    Optional<PersonalLoad> findByName(String name);
    List<PersonalLoad> findAllByProjectUser(ProjectUser projectUser);

    PersonalLoad findByProjectUserAndId(ProjectUser projectUser, Long id);
}
