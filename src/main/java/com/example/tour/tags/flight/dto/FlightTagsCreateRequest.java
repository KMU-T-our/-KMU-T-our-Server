package com.example.tour.tags.flight.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FlightTagsCreateRequest {

    private Date startDate;
    private Date startTime;
    private String startAirport;
    private Date combackDate;
    private Date combackTime;
    private String combackAirport;
}
