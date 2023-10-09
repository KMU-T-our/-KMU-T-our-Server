package com.example.tour.tags.home.domain;

import java.time.LocalDateTime;

import com.example.tour.tags.home.dto.HomeTagsCreateRequest;
import com.example.tour.tags.home.dto.HomeTagsUpdateRequest;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "homeTags")
@Entity
public class HomeTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private LocalDateTime checkInInfo;

    @Column
    private LocalDateTime checkOutInfo;

    @Column
    private int numberOfPeople;

    @Column
    private int numberOfRooms;

    public HomeTags(HomeTagsCreateRequest request){
        this.name = request.getName();
    }

    public void updateHomeTags(HomeTagsUpdateRequest request){
        this.name = request.getName();
        this.address = request.getAddress();
        this.checkInInfo = request.getCheckInInfo();
        this.checkOutInfo = request.getCheckOutInfo();
        this.numberOfPeople = request.getNumberOfPeople();
        this.numberOfRooms = request.getNumberOfRooms();
    }
}
