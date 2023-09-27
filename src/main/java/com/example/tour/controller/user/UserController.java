package com.example.tour.controller.user;

import com.example.tour.domain.user.User;
import com.example.tour.dto.user.request.UserUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tour.dto.user.request.UserCreateRequest;
import com.example.tour.service.user.UserServicev1;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    
    private final UserServicev1 userService;

    @PostMapping("/api/user") // Post /api/user
    public void saveUsers(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    @GetMapping("/api/user") // Get /api/user
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok()
                .body(userService.getUsers());
    }

    @PutMapping("/api/user")
    public void updateUsers(@RequestBody UserUpdateRequest request) {
        userService.updaterUser(request);
    }

    @DeleteMapping("/api/user")
    public void deleteUsers(@RequestParam String email){
        userService.deleteUser(email);
    }

}
