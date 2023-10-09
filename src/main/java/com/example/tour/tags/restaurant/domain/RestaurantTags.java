package com.example.tour.tags.restaurant.domain;

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

    @Column(nullable = false)
    private String name;

    @Column
    private String address;

    @Column
    private Date visitDate;

    @Column
    private String visitMeal;

    @Column
    private int numberOfPeople;

    public RestaurantTags(RestaurantTagsCreateRequest request){
        this.name = request.getName();
        this.address = request.getAddress();
        this.visitDate = request.getVisitDate();
        this.visitMeal = request.getVisitMeal();
        this.numberOfPeople = request.getNumberOfPeople();
    }

    public void updateRestaurantTags(RestaurantTagsUpdateRequest request){
        this.name = request.getName();
        this.address = request.getAddress();
        this.visitDate = request.getVisitDate();
        this.visitMeal = request.getVisitMeal();
        this.numberOfPeople = request.getNumberOfPeople();
    }
}

