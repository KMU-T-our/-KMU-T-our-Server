package com.example.tour.controller.token;

import com.example.tour.domain.token.Token;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @PostMapping("/api/token")
    public void token(@RequestBody Token token) {
        System.out.println(token.getToken());
    }
}