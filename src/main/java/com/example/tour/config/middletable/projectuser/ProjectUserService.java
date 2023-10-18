package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserDto;
import com.example.tour.config.middletable.projectuser.id.ProjectUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectUserService {

    private final ProjectUserRepository projectUserRepository;

    @Transactional
    public void saveProjectUser(ProjectUser projectUser) {
        projectUserRepository.save(projectUser);
    }

    @Transactional
    public List<ProjectUser> getAllProjectUser() {
        return projectUserRepository.findAll();
    }

    @Transactional
    public void deleteUserByProject(ProjectUserDto request){
        ProjectUser projectUser = new ProjectUser(request);
        projectUserRepository.delete(projectUser);
    }
}
