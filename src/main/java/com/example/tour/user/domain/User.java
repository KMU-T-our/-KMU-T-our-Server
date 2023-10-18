package com.example.tour.user.domain;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.user.dto.UserCreateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Table(name = "user")
@Entity
@NoArgsConstructor
@Builder()
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "social_id", nullable = false)
    private String socialId;

    @Column(name = "type")
    private String type;

    @Column
    @Nullable
    private String name;

    @Column
    @Nullable
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
