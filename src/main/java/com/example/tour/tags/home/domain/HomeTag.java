package com.example.tour.tags.home.domain;

import java.time.LocalDateTime;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.home.dto.HomeTagCreateRequest;
import com.example.tour.tags.home.dto.HomeTagUpdateRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "homeTag")
@Entity
public class HomeTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_tag_id")
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
    private String checkInDay;
    private String checkInTime;
    private String checkOutDay;
    private String checkOutTime;
    private Integer numberOfPeople;
    private Integer numberOfRooms;

    public HomeTag(Project project, Tag tag, HomeTagCreateRequest request) {
        this.tag = tag;
        this.project = project;
        this.name = request.getName();
        this.address = request.getAddress();
        this.checkInDay = request.getCheckInDay();
        this.checkInTime = request.getCheckInTime();
        this.checkOutDay = request.getCheckOutDay();
        this.checkOutTime = request.getCheckOutTime();
        this.numberOfPeople = request.getNumberOfPeople();
        this.numberOfRooms = request.getNumberOfRooms();
    }

    public void update(HomeTagUpdateRequest request) {
        if (request.getName() != null) this.name = request.getName();
        if (request.getAddress() != null) this.address = request.getAddress();
        if (request.getCheckInDay() != null) this.checkInDay = request.getCheckInDay();
        if (request.getCheckInTime() != null) this.checkInTime = request.getCheckInTime();
        if (request.getCheckOutDay() != null) this.checkOutDay = request.getCheckOutDay();
        if (request.getCheckOutTime() != null) this.checkOutTime = request.getCheckOutTime();
        if (request.getNumberOfPeople() != null) this.numberOfPeople = request.getNumberOfPeople();
        if (request.getNumberOfRooms() != null) this.numberOfRooms = request.getNumberOfRooms();
    }
}
