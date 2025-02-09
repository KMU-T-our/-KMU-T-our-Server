package com.example.tour.tags.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantTagCreateRequest {
    private Long projectId;
    private String name;
    private String address;
    private String visitDay;
    private String visitTime;
    private Integer numberOfPeople;
}
