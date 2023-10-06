package com.example.tour.user;

import com.example.tour.user.domain.User;
import com.example.tour.user.dto.UserCreateRequest;
import com.example.tour.user.dto.UserUpdateRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/api/user") // Post /api/user
    public void saveUsers(@RequestBody UserCreateRequest request) {
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
    public void deleteUsers(@RequestParam String email) {
        userService.deleteUser(email);
    }


}