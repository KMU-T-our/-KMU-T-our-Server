package com.example.tour.project;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Nullable
    @Column(name = "project_name")
    private String name;

//    @OneToMany
//    @JoinColumn(name = "project_id")
//    private List<ProjectUser> users = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }
}
