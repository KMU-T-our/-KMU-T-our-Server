package com.example.tour.user;

import com.example.tour.user.domain.User;
import com.example.tour.user.dto.UserCreateRequest;
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

    @PutMapping("/api/user")
    public void updateUsers(@RequestBody UserUpdateRequest request) {
        userService.updaterUser(request);
    }

    @DeleteMapping("/api/user")
    public void deleteUsers(@RequestParam String email) {
        userService.deleteUser(email);
    }
}
