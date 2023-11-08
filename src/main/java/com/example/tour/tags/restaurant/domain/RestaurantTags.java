package com.example.tour.tags.restaurant.domain;

import com.example.tour.config.middletable.tag.Tag;
import com.example.tour.project.Project;
import com.example.tour.tags.restaurant.dto.RestaurantTagsCreateRequest;
import com.example.tour.tags.restaurant.dto.RestaurantTagsUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurantTags")
@Entity
public class RestaurantTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(nullable = false)
    private String name;

    private String address;
    private Date visitDate;
    private String visitMeal;
    private int numberOfPeople;
}

