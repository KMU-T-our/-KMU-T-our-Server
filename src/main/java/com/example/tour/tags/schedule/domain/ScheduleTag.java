package com.example.tour.tags.schedule.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.schedule.dto.ScheduleTagCreateRequest;
import com.example.tour.tags.schedule.dto.ScheduleTagUpdateRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String name;

    @Column(nullable = false)
    private String date;

    @Column(columnDefinition = "TEXT")
    private String content;

    //태그 중간테이블과 매핑
    @OneToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Project project;

    public ScheduleTag(Project project, Tag tag, ScheduleTagCreateRequest request){
        this.name = request.getName();
        this.name = request.getName();
        this.date = request.getDate();
        this.content = request.getContent();

        this.project = project;
        this.tag = tag;
    }

    public void updateScheduleTag(ScheduleTagUpdateRequest request){
        if (request.getName() != null) this.name = request.getName();
        if (request.getDate() != null) this.date = request.getDate();
        if (request.getContent() != null) this.content = request.getContent();
    }
}
