package com.example.tour.controller.user;

import com.example.tour.domain.user.User;
import com.example.tour.dto.user.UserUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.tour.dto.user.UserCreateRequest;
import com.example.tour.service.user.UserServiceImpl;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    
    private final UserServiceImpl userService;

    @PostMapping("/api/user") // Post /api/user
    public void saveUsers(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    @GetMapping("/api/user") // Get /api/user
    public ResponseEntity<List<User>> getUsers() {
//        userService.findKakaoProfile("pn0CId8rdBNaCZAF4YSmmViGg9cqMW2MShRN66BJCj102wAAAYr6yV-W");
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
