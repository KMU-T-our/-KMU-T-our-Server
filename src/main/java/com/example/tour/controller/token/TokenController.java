package com.example.tour.controller.token;

import com.example.tour.domain.token.Token;
import com.example.tour.jwt.JwtProperties;
import com.example.tour.service.user.UserServiceImpl;
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

        System.out.println("token.getToken() = " + token.getToken());
        System.out.println("token.isKakao() = " + token.isKakao());
        if (token.isKakao()) { // 카카오 로그인
            String jwtToken = userService.saveUserKakaoAndGetToken(token.getToken());

            HttpHeaders headers = new HttpHeaders();
            headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

            return ResponseEntity.ok().headers(headers).body("success");
        } else { // 네이버 로그인

            return ResponseEntity.ok().body("not YET :(");
        }
    }
}