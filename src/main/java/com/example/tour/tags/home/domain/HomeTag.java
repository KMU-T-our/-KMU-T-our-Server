package com.example.tour.tags.home.domain;

import java.time.LocalDateTime;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.home.HomeTagsController;
import com.example.tour.tags.home.dto.HomeTagCreateRequest;
import com.example.tour.tags.home.dto.HomeTagUpdateRequest;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "homeTags")
@Entity
public class HomeTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_tag_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Tag tag;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private LocalDateTime checkInTime;

    @Column
    private LocalDateTime checkOutTime;

    @Column
    private int numberOfPeople;

    @Column
    private int numberOfRooms;

    public void updateHomeTags(HomeTagUpdateRequest request) {
        this.name = request.getName();
        this.address = request.getAddress();
        this.checkInTime = request.getCheckInTime();
        this.checkOutTime = request.getCheckOutTime();
        this.numberOfPeople = request.getNumberOfPeople();
        this.numberOfRooms = request.getNumberOfRooms();
    }

    public HomeTag(HomeTagCreateRequest request) {
        this.name = request.getName();
        this.address = request.getAddress();
        this.checkInTime = request.getCheckInTime();
        this.checkOutTime = request.getCheckOutTime();
        this.numberOfPeople = request.getNumberOfPeople();
        this.numberOfRooms = request.getNumberOfRooms();
    }
}
