package com.example.tour.load.personal.domain;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.load.personal.dto.PersonalLoadRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personalLoad")
@Entity
public class PersonalLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ColumnDefault("false")
    private boolean checkbox;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "project_id", nullable = false),
            @JoinColumn(name = "user_id", nullable = false)
    })
    private ProjectUser projectUser;

    public PersonalLoad(PersonalLoadRequest request, ProjectUser projectUser){
        this.name = request.getName();
        this.checkbox = request.isCheckbox();
        this.projectUser = projectUser;
    }

    /*public void setMapping(ProjectUser projectUser){
        this.projectUser = projectUser;
    }*/

    public void updatePersonalLoad(PersonalLoadRequest request){
        this.name = request.getName();
        this.checkbox = request.isCheckbox();
        //this.projectUser = request.getProjectUser();
    }
}
