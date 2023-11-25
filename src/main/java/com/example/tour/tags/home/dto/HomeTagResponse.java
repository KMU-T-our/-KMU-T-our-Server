package com.example.tour.tags.home.dto;

import com.example.tour.config.ResponseComparator;
import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.home.domain.HomeTag;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.results.graph.collection.internal.SelectEagerCollectionAssembler;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
public class HomeTagResponse implements ResponseComparator {
    private Long tagId;
    private String tagType = "home";
    private String name;
    private String address;
    private String checkInDay;
    private String checkInTime;
    private String checkOutDay;
    private String checkOutTime;
    private Integer numberOfPeople;
    private Integer numberOfRooms;

    public HomeTagResponse(HomeTag tag) {
        this.tagId = tag.getTag().getTagId();
        this.name = tag.getName();
        this.address = tag.getAddress();
        this.checkInDay = tag.getCheckInDay();
        this.checkInTime = tag.getCheckInTime();
        this.checkOutDay = tag.getCheckOutDay();
        this.checkOutTime = tag.getCheckOutTime();
        this.numberOfPeople = tag.getNumberOfPeople();
        this.numberOfRooms = tag.getNumberOfRooms();
    }
}
