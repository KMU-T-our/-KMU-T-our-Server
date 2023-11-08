package com.example.tour.tags.flight.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.tags.flight.dto.FlightTagsCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagsUpdateRequest;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FLIGHT_TAG")
@Entity
@Builder
public class FlightTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightTagId;

    @Column(nullable = false)
    private LocalDateTime startTakeoffDateTime;

    @Column(nullable = false)
    private LocalDateTime startLandingDateTime;

    @Column(nullable = false)
    private String startTakeoffAirport;

    @Column(nullable = false)
    private String startLandingAirport;

    @Column(nullable = false)
    private LocalDateTime endTakeoffDateTime;

    @Column(nullable = false)
    private LocalDateTime endLandingDateTime;

    @Column(nullable = false)
    private String endTakeoffAirport;

    @Column(nullable = false)
    private String endLandingAirport;

    @OneToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;


    public FlightTag(FlightTagsCreateRequest request) {
        this.startTakeoffDateTime = request.getStartTakeoffDateTime();
        this.startLandingDateTime = request.getStartLandingDateTime();
        this.startTakeoffAirport = request.getStartTakeoffAirport();
        this.startLandingAirport = request.getStartLandingAirport();

        this.endTakeoffDateTime = request.getEndTakeoffDateTime();
        this.endLandingDateTime = request.getEndLandingDateTime();
        this.endTakeoffAirport = request.getEndTakeoffAirport();
        this.endLandingAirport = request.getEndLandingAirport();
    }

    public void updateFlightTag(FlightTagsUpdateRequest request) {
        this.startTakeoffDateTime = request.getStartTakeoffDateTime();
        this.startLandingDateTime = request.getStartLandingDateTime();
        this.startTakeoffAirport = request.getStartTakeoffAirport();
        this.startLandingAirport = request.getStartLandingAirport();

        this.endTakeoffDateTime = request.getEndTakeoffDateTime();
        this.endLandingDateTime = request.getEndLandingffDateTime();
        this.endTakeoffAirport = request.getEndTakeoffAirport();
        this.endLandingAirport = request.getEndLandingAirport();
    }
}

