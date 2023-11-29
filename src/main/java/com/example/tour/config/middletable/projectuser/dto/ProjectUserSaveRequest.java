package com.example.tour.config.middletable.projectuser.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjectUserSaveRequest {
    List<String> userIdentity;
    Long projectId;
}
