package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserDto;
import com.example.tour.config.middletable.projectuser.id.ProjectUserId;
import com.example.tour.project.Project;
import com.example.tour.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Getter
@Entity
@Table(name = "PROJECT_USER")
@NoArgsConstructor
public class ProjectUser implements Persistable<ProjectUserId> {

    @EmbeddedId
    private ProjectUserId id;

    public ProjectUser(ProjectUserDto projectUserDto) {
        this.id = new ProjectUserId(projectUserDto.getProjectId(), projectUserDto.getUserId());
    }

    @MapsId(value = "project_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @MapsId(value = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    /*
    @OneToOne(mappedBy = "projectUser")
    private PersonalLoad personalLoad;
    굳이 양방향 안해도 될듯하다.
    */

    @Override
    public ProjectUserId getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }
}
