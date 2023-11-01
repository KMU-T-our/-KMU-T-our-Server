package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserSaveRequest;
import com.example.tour.project.Project;
import com.example.tour.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "PROJECT_USER")
@NoArgsConstructor
public class ProjectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectUserId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ProjectUser(Project project, User user) {
        this.project = project;
        this.user = user;
    }
}
