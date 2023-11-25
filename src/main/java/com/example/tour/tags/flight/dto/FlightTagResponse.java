package com.example.tour.tags.flight.dto;

import com.example.tour.config.ResponseComparator;
import com.example.tour.tags.flight.domain.FlightTag;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlightTagResponse implements ResponseComparator {
    private Long tagId;
    private String tagType = "flight";
    private String airline;
    private String startTakeoffTime;
    private String startLandingTime;
    private String startTakeoffAirport;
    private String startLandingAirport;

    private String endTakeoffTime;
    private String endLandingTime;
    private String endTakeoffAirport;
    private String endLandingAirport;

    public FlightTagResponse(FlightTag tag) {
        this.tagId = tag.getTag().getTagId();
        this.airline = tag.getAirline();
        this.startTakeoffTime = tag.getStartTakeoffTime();
        this.startLandingTime = tag.getStartLandingTime();
        this.startTakeoffAirport = tag.getStartTakeoffAirport();
        this.startLandingAirport = tag.getStartLandingAirport();
        this.endTakeoffTime = tag.getEndTakeoffTime();
        this.endLandingTime = tag.getEndLandingTime();
        this.endTakeoffAirport = tag.getEndTakeoffAirport();
        this.endLandingAirport = tag.getEndLandingAirport();
    }


}
