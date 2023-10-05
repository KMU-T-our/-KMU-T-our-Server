package com.example.tour.jwt;

public interface JwtProperties {
    String SECRET = "vgbqny123123123aszxcbqr8114553tqblma3416341531kadmklvaasdadflvkm23";
    int EXPIRATION_TIME =  864000000; // 10일, ms 단위이다.
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}