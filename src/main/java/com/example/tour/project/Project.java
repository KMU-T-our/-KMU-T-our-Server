package com.example.tour.project;

import com.example.tour.tags.flight.domain.FlightTag;
import com.example.tour.tags.home.domain.HomeTag;
import com.example.tour.tags.restaurant.domain.RestaurantTag;
import com.example.tour.tags.schedule.domain.ScheduleTag;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Nullable
    @Column(name = "project_name", nullable = false)
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "start_day")
    private Date startDay;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "end_day")
    private Date endDay;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<HomeTag> homeTags;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<FlightTag> flightTags;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<RestaurantTag> restaurantTags;
}
