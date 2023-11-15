package com.example.tour.tags.flight.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class FlightTagUpdateRequest {

    private Long tagId;
    private String airline;

    private String startTakeoffTime;
    private String startLandingTime;
    private String startTakeoffAirport;
    private String startLandingAirport;

    private String endTakeoffTime;
    private String endLandingTime;
    private String endTakeoffAirport;
    private String endLandingAirport;
}
