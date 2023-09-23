package com.example.tour.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tour.domain.user.User;
import com.example.tour.domain.user.UserRepository;
import com.example.tour.dto.user.request.UserCreateRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServicev1 {
    
    private final UserRepository UserRepository;
    
    @Transactional
    public void saveUser(UserCreateRequest request){
        User u = UserRepository.save(new User(request.getId(), request.getName()));
    }
}
