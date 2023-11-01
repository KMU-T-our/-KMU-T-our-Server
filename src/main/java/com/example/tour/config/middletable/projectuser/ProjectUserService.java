package com.example.tour.config.middletable.projectuser;

import com.example.tour.config.middletable.projectuser.dto.ProjectUserResponse;
import com.example.tour.config.middletable.projectuser.dto.ProjectUserSaveRequest;
import com.example.tour.project.Project;
import com.example.tour.project.ProjectRepository;
import com.example.tour.user.UserRepository;
import com.example.tour.user.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectUserService {
    private final ProjectUserRepository projectUserRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Transactional
    public ProjectUserResponse save(ProjectUserSaveRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        ProjectUser projectUser = projectUserRepository.save(new ProjectUser(project, user));
        return new ProjectUserResponse(projectUser.getProjectUserId());
    }
}
