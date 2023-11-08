package com.example.tour.tags.flight.dto;

import com.example.tour.tags.flight.domain.FlightTag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
public class FlightTagResponse {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTakeoffDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startLandingDateTime;
    private String startTakeoffAirport;
    private String startLandingAirport;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTakeoffDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endLandingDateTime;
    private String endTakeoffAirport;
    private String endLandingAirport;

    public FlightTagResponse(FlightTag tag) {
        this.startTakeoffDateTime = tag.getStartTakeoffDateTime();
        this.startLandingDateTime = tag.getStartLandingDateTime();
        this.startTakeoffAirport = tag.getStartTakeoffAirport();
        this.startLandingAirport = tag.getStartLandingAirport();
        this.endTakeoffDateTime = tag.getEndTakeoffDateTime();
        this.endLandingDateTime = tag.getEndLandingDateTime();
        this.endTakeoffAirport = tag.getEndTakeoffAirport();
        this.endLandingAirport = tag.getEndLandingAirport();
    }
}
