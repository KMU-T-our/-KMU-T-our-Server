package com.example.tour.token;

import com.example.tour.token.jwt.JwtProperties;
import com.example.tour.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final UserServiceImpl userService;

    @GetMapping("/api/token")
    public ResponseEntity<String> token(@RequestBody Token token) { //
        String jwtToken = null;
        if (token.isKakao()) { // 카카오 로그인
            jwtToken = userService.saveUserKakaoAndGetToken(token.getToken());
        } else { // 네이버 로그인
            jwtToken = userService.saveUserNaverAndGetToken(token.getToken());

        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

        return ResponseEntity.ok().headers(headers).body("success");
    }
}