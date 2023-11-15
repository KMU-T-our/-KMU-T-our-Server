package com.example.tour.tags.home.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class HomeTagUpdateRequest {
    private Long tagId;
    private String name;
    private String address;
    private String checkInDay;
    private String checkInTime;
    private String checkOutDay;
    private String checkOutTime;
    private Integer numberOfPeople;
    private Integer numberOfRooms;
}
