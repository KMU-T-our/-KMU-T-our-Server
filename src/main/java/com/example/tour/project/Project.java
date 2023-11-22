package com.example.tour.project;

import com.example.tour.project.dto.ProjectUpdateDTO;
import com.example.tour.tags.flight.domain.FlightTag;
import com.example.tour.tags.home.domain.HomeTag;
import com.example.tour.tags.restaurant.domain.RestaurantTag;
import com.example.tour.tags.schedule.domain.ScheduleTag;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "start_day")
    private String startDay;

    @Column(name = "end_day")
    private String endDay;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<HomeTag> homeTags;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<FlightTag> flightTags;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<RestaurantTag> restaurantTags;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<ScheduleTag> scheduleTags;

    public void update(ProjectUpdateDTO request) {
        if (request.getName() != null) this.name = request.getName();
        if (request.getStartDay() != null) this.startDay = request.getStartDay();
        if (request.getEndDay() != null) this.endDay = request.getEndDay();
    }
}
