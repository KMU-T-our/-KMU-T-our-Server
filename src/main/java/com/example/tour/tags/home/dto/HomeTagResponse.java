package com.example.tour.tags.home.dto;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.home.domain.HomeTag;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.results.graph.collection.internal.SelectEagerCollectionAssembler;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
public class HomeTagResponse {
    private String name;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime checkInTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime checkOutTime;
    private Integer numberOfPeople;
    private Integer numberOfRooms;

    public HomeTagResponse(HomeTag tag) {
        this.name = tag.getName();
        this.address = tag.getAddress();
        this.checkInTime = tag.getCheckInTime();
        this.checkOutTime = tag.getCheckOutTime();
        this.numberOfPeople = tag.getNumberOfPeople();
        this.numberOfRooms = tag.getNumberOfRooms();
    }
}
