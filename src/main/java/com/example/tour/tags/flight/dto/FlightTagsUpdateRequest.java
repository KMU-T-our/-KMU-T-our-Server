package com.example.tour.tags.flight.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class FlightTagsUpdateRequest {

    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTakeoffDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startLandingDateTime;
    private String startTakeoffAirport;
    private String startLandingfAirport;
    private String startSeat;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime combackTakeoffDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime combackLandingffDateTime;
    private String combackTakeoffAirport;
    private String combackLandingAirport;
    private String combackSeat;
}
