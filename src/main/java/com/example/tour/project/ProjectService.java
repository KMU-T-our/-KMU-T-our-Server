package com.example.tour.project;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.project.dto.ProjectResponse;
import com.example.tour.project.dto.ProjectSaveRequest;
import com.example.tour.project.dto.ProjectSaveResponse;
import com.example.tour.user.UserRepository;
import com.example.tour.user.domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectUserRepository projectUserRepository;
    private final UserRepository userRepository;

    @Transactional
    public ProjectSaveResponse saveProject(ProjectSaveRequest request) {
        Project project = Project.builder()
                .name(request.getProjectName())
                .startDay(request.getStartDay())
                .endDay(request.endDay)
                .build();
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        ProjectUser projectUser = new ProjectUser(project, user);
        projectUserRepository.save(projectUser);
        projectRepository.save(project);
        return new ProjectSaveResponse(projectUser.getProjectUserId(), project);
    }

    public List<ProjectResponse> getProjectByUserId(Long userId) {
        return projectUserRepository.findByUserId(userId)
                .stream()
                .map(ProjectResponse::new)
                .toList();
    }
}
