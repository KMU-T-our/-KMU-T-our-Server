package com.example.tour.project;

import com.example.tour.config.ResponseComparator;
import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.project.dto.ProjectResponse;
import com.example.tour.project.dto.ProjectSaveRequest;
import com.example.tour.project.dto.ProjectSaveResponse;
import com.example.tour.project.dto.ProjectUpdateDTO;
import com.example.tour.tags.flight.dto.FlightTagResponse;
import com.example.tour.tags.home.dto.HomeTagResponse;
import com.example.tour.tags.restaurant.dto.RestaurantTagResponse;
import com.example.tour.tags.schedule.dto.ScheduleTagResponse;
import com.example.tour.user.UserRepository;
import com.example.tour.user.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectUserRepository projectUserRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    public ProjectSaveResponse saveProject(ProjectSaveRequest request) {
        Project project = Project.builder()
                .name(request.getProjectName())
                .startDay(request.getStartDay())
                .endDay(request.getEndDay())
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

    @Transactional
    public List<Object> getTags(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(IllegalArgumentException::new);

        List<HomeTagResponse> homeTagResponseList = project.getHomeTags().stream()
                .map(HomeTagResponse::new).toList();
        List<FlightTagResponse> flightTagResponseList = project.getFlightTags().stream()
                .map(FlightTagResponse::new).toList();
        List<RestaurantTagResponse> restaurantTagResponseList = project.getRestaurantTags().stream()
                .map(RestaurantTagResponse::new).toList();
        List<ScheduleTagResponse> scheduleTagResponseList = project.getScheduleTags().stream()
                .map(ScheduleTagResponse::new).toList();

        List<Object> result = new ArrayList<>(homeTagResponseList);
        result.addAll(flightTagResponseList);
        result.addAll(restaurantTagResponseList);
        result.addAll(scheduleTagResponseList);
        result.sort((o1, o2) -> Math.toIntExact(((((ResponseComparator) o1).getTagId() - ((ResponseComparator) o2).getTagId()))));
        return result;
    }

    @Transactional
    public List<Object> getThreeTags(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(IllegalArgumentException::new);

        List<FlightTagResponse> flightTagResponseList = project.getFlightTags().stream()
                .map(FlightTagResponse::new).toList();
        List<HomeTagResponse> homeTagResponseList = project.getHomeTags().stream()
                .map(HomeTagResponse::new).toList();
        List<RestaurantTagResponse> restaurantTagResponseList = project.getRestaurantTags().stream()
                .map(RestaurantTagResponse::new).toList();

        List<Object> result = new ArrayList<>(flightTagResponseList);
        result.addAll(homeTagResponseList);
        result.addAll(restaurantTagResponseList);

        return result;

    }
    @Transactional
    public ProjectUpdateDTO updateProject(ProjectUpdateDTO request) {
        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(IllegalArgumentException::new);
        project.update(request);
        return new ProjectUpdateDTO(project);
    }
}
