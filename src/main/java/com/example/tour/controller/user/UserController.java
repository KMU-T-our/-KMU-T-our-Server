package com.example.tour.controller.user;

import com.example.tour.domain.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tour.dto.user.request.UserCreateRequest;
import com.example.tour.service.user.UserServicev1;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    
    private final UserServicev1 userService;

    @PostMapping("/api/user") // Post /api/user
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    @GetMapping("/api/user") // Get /api/user
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok()
                .body(userService.getUsers());
    }
}
