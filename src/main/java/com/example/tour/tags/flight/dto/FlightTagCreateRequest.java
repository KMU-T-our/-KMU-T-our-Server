package com.example.tour.tags.flight.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlightTagCreateRequest {
    private Long projectId;

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
