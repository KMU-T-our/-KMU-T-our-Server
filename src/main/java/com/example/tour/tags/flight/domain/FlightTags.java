package com.example.tour.tags.flight.domain;

import com.example.tour.tags.flight.dto.FlightTagsCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagsUpdateRequest;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flightTags")
@Entity
public class FlightTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startTakeoffDateTime;

    @Column(nullable = false)
    private LocalDateTime startLandingDateTime;

    @Column(nullable = false)
    private String startTakeoffAirport;

    @Column(nullable = false)
    private String startLandingfAirport;

    @Column
    private String startSeat;

    @Column(nullable = false)
    private LocalDateTime combackTakeoffDateTime;

    @Column(nullable = false)
    private LocalDateTime combackLandingffDateTime;

    @Column(nullable = false)
    private String combackTakeoffAirport;

    @Column(nullable = false)
    private String combackLandingAirport;

    @Column
    private String combackSeat;

    public FlightTags(FlightTagsCreateRequest request) {
        this.startTakeoffDateTime = request.getStartTakeoffDateTime();
        this.startLandingDateTime = request.getStartLandingDateTime();
        this.startTakeoffAirport = request.getStartTakeoffAirport();
        this.startLandingfAirport = request.getStartLandingfAirport();

        this.combackTakeoffDateTime = request.getCombackTakeoffDateTime();
        this.combackLandingffDateTime = request.getCombackLandingffDateTime();
        this.combackTakeoffAirport = request.getCombackTakeoffAirport();
        this.combackLandingAirport = request.getCombackLandingAirport();
    }

    // update 용
    public void updateDB(FlightTagsUpdateRequest request) {
        this.startTakeoffDateTime = request.getStartTakeoffDateTime();
        this.startLandingDateTime = request.getStartLandingDateTime();
        this.startTakeoffAirport = request.getStartTakeoffAirport();
        this.startLandingfAirport = request.getStartLandingfAirport();
        this.startSeat = request.getStartSeat();

        this.combackTakeoffDateTime = request.getCombackTakeoffDateTime();
        this.combackLandingffDateTime = request.getCombackLandingffDateTime();
        this.combackTakeoffAirport = request.getCombackTakeoffAirport();
        this.combackLandingAirport = request.getCombackLandingAirport();
        this.combackSeat = request.getCombackSeat();
    }
}

