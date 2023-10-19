package com.example.tour.token;

import com.example.tour.user.UserServiceImpl;
import com.example.tour.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final UserServiceImpl userService;

    @GetMapping("/api/token")
    public ResponseEntity<User> token(Token token) {
        ResponseEntity<User> response = null;
        if (token.getType().equals("kakao")) { // 카카오 로그인
            response = userService.saveUserKakaoAndGetToken(token.getToken());
        } else if (token.getType().equals("naver")) { // 네이버 로그인
            response = userService.saveUserNaverAndGetToken(token.getToken());
        }
        return response;
    }
}