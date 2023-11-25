package com.example.tour.tags.restaurant.dto;

import com.example.tour.config.ResponseComparator;
import com.example.tour.tags.restaurant.domain.RestaurantTag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantTagResponse implements ResponseComparator {
    private Long tagId;
    private String tagType = "restaurant";
    private String name;
    private String address;
    private String visitDay;
    private String visitTime;
    private Integer numberOfPeople;

    public RestaurantTagResponse(RestaurantTag tag) {
        this.tagId = tag.getTag().getTagId();
        this.name = tag.getName();
        this.address = tag.getAddress();
        this.visitDay = tag.getVisitDay();
        this.visitTime = tag.getVisitTime();
        this.numberOfPeople = tag.getNumberOfPeople();
    }
}
