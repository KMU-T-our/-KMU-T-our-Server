package com.example.tour.controller.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tour.dto.user.request.UserCreateRequest;
import com.example.tour.service.user.UserServicev1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserController {
    
    private final UserServicev1 userService;

    @PostMapping("/user") // Post /user
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }


}
