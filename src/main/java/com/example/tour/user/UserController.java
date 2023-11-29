package com.example.tour.user;

import com.example.tour.user.domain.User;
import com.example.tour.user.dto.UserCreateRequest;
import com.example.tour.user.dto.UserResponse;
import com.example.tour.user.dto.UserUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok()
                .body(userService.getUsers());
    }

    @GetMapping("/api/user/member")
    public User getMember(@RequestParam Long projectUserId){
        return userService.getMember(projectUserId);
    }

    @PutMapping("/api/user")
    public void updateUsers(@RequestBody UserUpdateRequest request) {
        userService.updaterUser(request);
    }

    @DeleteMapping("/api/user")
    public void deleteUsers(@RequestParam String email) {
        userService.deleteUser(email);
    }

    // 프로젝트에 포함되어 있는 유저들 표시
    @GetMapping("/api/usersByProjectId")
    public List<UserResponse> getUsersInProject(@RequestParam Long projectId) {
        return userService.getUsersInProject(projectId);
    }
}
