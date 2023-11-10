package com.example.tour.tags.restaurant.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.restaurant.dto.RestaurantTagCreateRequest;
import com.example.tour.tags.restaurant.dto.RestaurantTagUpdateRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurantTags")
@Entity
public class RestaurantTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(nullable = false)
    private String name;

    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime visitDay;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime visitTime;
    private Integer numberOfPeople;

    public RestaurantTag(Project project, Tag tag, RestaurantTagCreateRequest request) {
        this.project = project;
        this.tag = tag;
        this.name = request.getName();
        this.address = request.getAddress();
        this.visitDay = request.getVisitDay();
        this.visitTime = request.getVisitTime();
        this.numberOfPeople = request.getNumberOfPeople();
    }

    public void update(RestaurantTagUpdateRequest request) {
        if (request.getName() != null) this.name = request.getName();
        if (request.getAddress() != null) this.address = request.getAddress();
        if (request.getVisitDay() != null) this.visitDay = request.getVisitDay();
        if (request.getVisitTime() != null) this.visitTime = request.getVisitTime();
        if (request.getNumberOfPeople() != null) this.numberOfPeople = request.getNumberOfPeople();
    }
}

