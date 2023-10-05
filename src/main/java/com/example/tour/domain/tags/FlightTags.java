package com.example.tour.domain.tags;

import com.example.tour.dto.tags.FlightTagsCreateRequest;
import com.example.tour.dto.tags.FlightTagsUpdateRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flightTags")
@Entity
public class FlightTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date startTime;

    @Column(nullable = false)
    private String startAirport;

    @Column
    private String startSeat;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date combackDate;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date combackTime;

    @Column(nullable = false)
    private String combackAirport;

    @Column
    private String combackSeat;


    public FlightTags(FlightTagsCreateRequest request){
        this.startDate = request.getStartDate();
        this.startTime = request.getStartTime();
        this.startAirport = request.getStartAirport();

        this.combackDate = request.getCombackDate();
        this.combackTime = request.getCombackTime();
        this.combackAirport = request.getCombackAirport();
    }

    // update 용
    public void updateDB(FlightTagsUpdateRequest request){
        this.startDate = request.getStartDate();
        this.startTime = request.getStartTime();
        this.startAirport = request.getStartAirport();
        this.combackDate = request.getCombackDate();
        this.combackTime = request.getCombackTime();
        this.combackAirport = request.getCombackAirport();
    }
}

