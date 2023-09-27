package com.example.tour.service.user;

import com.example.tour.dto.user.request.UserUpdateRequest;
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

    @Transactional
    public void updaterUser(UserUpdateRequest request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateDB(request.getName(), request.getEmail());
    }

    // email 로 지우기 : emainl,id 는 1대1로 매핑되는 고유정보임
    // kakao, naver 에서 email 정보 받아올거임
    // kakao 랑 naver 랑 email 정보 같으면 어떡하지? (이건 갑자기 생긴 의문)
    @Transactional
    public void deleteUser(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }
}
