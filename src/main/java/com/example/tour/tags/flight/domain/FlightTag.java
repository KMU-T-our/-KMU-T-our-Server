package com.example.tour.tags.flight.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.flight.dto.FlightTagCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagUpdateRequest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false)
    private String startTakeoffTime;

    @Column(nullable = false)
    private String startLandingTime;

    @Column(nullable = false)
    private String startTakeoffAirport;

    @Column(nullable = false)
    private String startLandingAirport;

    @Column(nullable = false)
    private String endTakeoffTime;

    @Column(nullable = false)
    private String endLandingTime;

    @Column(nullable = false)
    private String endTakeoffAirport;

    @Column(nullable = false)
    private String endLandingAirport;


    public FlightTag(Project project,Tag tag, FlightTagCreateRequest request) {
        this.tag = tag;
        this.project = project;

        this.startTakeoffTime = request.getStartTakeoffTime();
        this.startLandingTime = request.getStartLandingTime();
        this.startTakeoffAirport = request.getStartTakeoffAirport();
        this.startLandingAirport = request.getStartLandingAirport();

        this.endTakeoffTime = request.getEndTakeoffTime();
        this.endLandingTime = request.getEndLandingTime();
        this.endTakeoffAirport = request.getEndTakeoffAirport();
        this.endLandingAirport = request.getEndLandingAirport();
    }

    public void updateFlightTag(FlightTagUpdateRequest request) {
        if(request.getStartTakeoffTime() != null) this.startTakeoffTime = request.getStartTakeoffTime();
        if(request.getStartLandingTime() != null) this.startLandingTime = request.getStartLandingTime();
        if(request.getStartTakeoffAirport() != null) this.startTakeoffAirport = request.getStartTakeoffAirport();
        if(request.getStartLandingAirport() != null) this.startLandingAirport = request.getStartLandingAirport();

        if(request.getEndTakeoffTime() != null) this.endTakeoffTime = request.getEndTakeoffTime();
        if(request.getEndLandingTime() != null) this.endLandingTime = request.getEndLandingTime();
        if(request.getEndTakeoffAirport() != null) this.endTakeoffAirport = request.getEndTakeoffAirport();
        if(request.getEndLandingAirport() != null) this.endLandingAirport = request.getEndLandingAirport();
    }
}

