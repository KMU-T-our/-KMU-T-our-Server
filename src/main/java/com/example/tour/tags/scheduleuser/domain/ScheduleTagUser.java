package com.example.tour.tags.scheduleuser.domain;

import com.example.tour.tags.schedule.domain.ScheduleTag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class ScheduleTagUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleTagUserId;

    @ManyToOne
    @JoinColumn(name = "schedule_tag_id")
    private ScheduleTag scheduleTag;

    private Long userId;


    public ScheduleTagUser(ScheduleTag scheduleTag, Long userId){
        this.scheduleTag = scheduleTag;
        this.userId = userId;
    }

}
