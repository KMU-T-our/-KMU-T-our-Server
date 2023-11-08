package com.example.tour.tags.restaurant.dto;

import com.example.tour.tags.restaurant.domain.RestaurantTag;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RestaurantTagResponse {
    private String name;
    private String address;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime visitDay;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime visitTime;
    private Integer numberOfPeople;

    public RestaurantTagResponse(RestaurantTag tag) {
        this.name = tag.getName();
        this.address = tag.getAddress();
        this.visitDay = tag.getVisitDay();
        this.visitTime = tag.getVisitTime();
        this.numberOfPeople = tag.getNumberOfPeople();
    }
}
