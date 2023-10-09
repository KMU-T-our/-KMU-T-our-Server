package com.example.tour.tags.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantTagsUpdateRequest {
    private Long id;
    private String name;
    private String address;
    private Date visitDate;
    private String visitMeal;
    private int numberOfPeople;
}


