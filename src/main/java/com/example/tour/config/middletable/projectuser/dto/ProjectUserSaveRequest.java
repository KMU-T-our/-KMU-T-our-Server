package com.example.tour.config.middletable.projectuser.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectUserSaveRequest {
    String userIdentity;
    Long projectId;
}
