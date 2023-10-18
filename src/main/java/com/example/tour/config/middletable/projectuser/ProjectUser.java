package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserDto;
import com.example.tour.config.middletable.projectuser.id.ProjectUserId;
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

    @Override
    public ProjectUserId getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }
}
