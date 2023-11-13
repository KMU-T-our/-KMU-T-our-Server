package com.example.tour.tags.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantTagUpdateRequest {
    private Long tagId;
    private String name;
    private String address;
    private String visitDay;
    private String visitTime;
    private Integer numberOfPeople;
}


