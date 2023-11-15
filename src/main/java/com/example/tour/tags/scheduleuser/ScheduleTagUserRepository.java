package com.example.tour.tags.scheduleuser;

import com.example.tour.tags.scheduleuser.domain.ScheduleTagUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleTagUserRepository extends JpaRepository<ScheduleTagUser, Long> {

    List<ScheduleTagUser> findByScheduleTagId(Long ScheduleTagId);
}
