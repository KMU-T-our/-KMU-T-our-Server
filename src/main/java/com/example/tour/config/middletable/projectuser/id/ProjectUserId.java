package com.example.tour.config.middletable.projectuser.id;

import com.example.tour.project.Project;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class ProjectUserId implements Serializable {
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "user_id")
    private Long userId;

    public ProjectUserId(Long projectId, Long userId) {
        this.projectId = projectId;
        this.userId = userId;
    }
}