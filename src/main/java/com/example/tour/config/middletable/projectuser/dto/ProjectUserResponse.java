package com.example.tour.config.middletable.projectuser.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectUserResponse {
    public Long projectUserId;

    public ProjectUserResponse(Long projectUserId) {
        this.projectUserId = projectUserId;
    }
}
