package com.example.tour.tags.home.domain;

import java.time.LocalDateTime;

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

}
