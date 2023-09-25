package com.example.tour.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tour.domain.user.User;
import com.example.tour.domain.user.UserRepository;
import com.example.tour.dto.user.request.UserCreateRequest;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServicev1 {
    
    private final UserRepository userRepository;
    
    @Transactional
    public void saveUser(UserCreateRequest request){
        User u = userRepository.save(new User(request));
    }

    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
