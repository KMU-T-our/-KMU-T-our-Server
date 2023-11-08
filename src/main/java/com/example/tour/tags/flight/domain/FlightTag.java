package com.example.tour.tags.flight.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.flight.dto.FlightTagCreateRequest;
import com.example.tour.tags.flight.dto.FlightTagUpdateRequest;

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

    @OneToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

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


    public FlightTag(Project project,Tag tag, FlightTagCreateRequest request) {
        this.tag = tag;
        this.project = project;

        this.startTakeoffDateTime = request.getStartTakeoffDateTime();
        this.startLandingDateTime = request.getStartLandingDateTime();
        this.startTakeoffAirport = request.getStartTakeoffAirport();
        this.startLandingAirport = request.getStartLandingAirport();

        this.endTakeoffDateTime = request.getEndTakeoffDateTime();
        this.endLandingDateTime = request.getEndLandingDateTime();
        this.endTakeoffAirport = request.getEndTakeoffAirport();
        this.endLandingAirport = request.getEndLandingAirport();
    }

    public void updateFlightTag(FlightTagUpdateRequest request) {
        if(request.getStartTakeoffDateTime() != null) {
            this.startTakeoffDateTime = request.getStartTakeoffDateTime();
        }
        if(request.getStartLandingDateTime() != null){
            this.startLandingDateTime = request.getStartLandingDateTime();
        }
        if(request.getStartTakeoffAirport() != null){
            this.startTakeoffAirport = request.getStartTakeoffAirport();
        }
        if(request.getStartLandingAirport() != null){
            this.startLandingAirport = request.getStartLandingAirport();
        }

        if(request.getEndTakeoffDateTime() != null){
            this.endTakeoffDateTime = request.getEndTakeoffDateTime();
        }
        if(request.getEndLandingDateTime() != null){
            this.endLandingDateTime = request.getEndLandingDateTime();
        }
        if(request.getEndTakeoffAirport() != null){
            this.endTakeoffAirport = request.getEndTakeoffAirport();
        }
        if(request.getEndLandingAirport() != null){
            this.endLandingAirport = request.getEndLandingAirport();
        }
    }
}

