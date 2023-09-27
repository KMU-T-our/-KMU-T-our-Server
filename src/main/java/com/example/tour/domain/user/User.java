package com.example.tour.domain.user;

import com.example.tour.dto.user.request.UserCreateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(UserCreateRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
    }

    // update
    public void updateDB(String name, String email){
        this.name = name;
        this.email = email;
    }

}
