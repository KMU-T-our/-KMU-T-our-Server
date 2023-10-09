package com.example.tour.token;

import lombok.Getter;
import lombok.Setter;


/**
 * 토큰 전달받는 클래스,
 * 타입으로 올 수 있는 값은 "naver", "kakao"
 */
@Getter
@Setter
public class Token {
    String token;
    String type;
}