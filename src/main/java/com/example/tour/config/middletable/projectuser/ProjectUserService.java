package com.example.tour.config.middletable.projectuser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectUserService {

    private final ProjectUserRepository projectUserRepository;

    public void saveProjectUser(ProjectUser projectUser) {
        projectUserRepository.save(projectUser);
    }

    public List<ProjectUser> getAllProjectUser() {
        return projectUserRepository.findAll();
    }


}
