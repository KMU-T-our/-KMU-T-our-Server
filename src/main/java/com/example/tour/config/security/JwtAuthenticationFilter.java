package com.example.tour.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // JWT 검증 필터 추가
    // 테스트를 위해 일단은 주석처리
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        filterChain.doFilter(request, response);

//        String url = request.getRequestURL().toString();
//        if(!url.equals("http://localhost:8080/api/token")) {
//            try {
//                String authorizationHeader = request.getHeader(JwtProperties.HEADER_STRING);
//                String token = authorizationHeader.replace(JwtProperties.TOKEN_PREFIX, "");
//                JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token);
//            } catch (Exception e) {
//                response.sendError(401);
//                response.setStatus(401);
//            }
//        }
//        filterChain.doFilter(request, response);
    }
}
