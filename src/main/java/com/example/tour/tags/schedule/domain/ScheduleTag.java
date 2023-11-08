package com.example.tour.tags.schedule.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.schedule.dto.ScheduleTagRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scheduleTag")
@Entity
public class ScheduleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_tag_id")
    private Long id;

    @Column(nullable = false)
    private String scheduleName;

    @Column(nullable = false)
    private String scheduleDate;

    @Column(columnDefinition = "TEXT")
    private String scheduleContent;

    //태그 중간테이블과 매핑
    @OneToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public ScheduleTag(ScheduleTagRequest request){
        this.scheduleName = request.getScheduleName();
        this.scheduleDate = request.getScheduleDate();
        this.scheduleContent = request.getScheduleContent();
    }

    public void updateScheduleTag(ScheduleTagRequest request){
        this.scheduleName = request.getScheduleName();
        this.scheduleDate = request.getScheduleDate();
        this.scheduleContent = request.getScheduleContent();
    }
}
