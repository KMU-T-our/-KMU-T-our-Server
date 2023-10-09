package com.example.tour.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.tour.token.jwt.JwtProperties;
import com.example.tour.user.domain.User;
import com.example.tour.user.dto.KakaoProfile;
import com.example.tour.user.dto.NaverProfile;
import com.example.tour.user.dto.UserCreateRequest;
import com.example.tour.user.dto.UserUpdateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request));
    }

    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void updaterUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateDB(request.getName(), request.getEmail());
    }

    // email 로 지우기 : emainl,id 는 1대1로 매핑되는 고유정보임
    // kakao, naver 에서 email 정보 받아올거임
    // kakao 랑 naver 랑 email 정보 같으면 어떡하지? (이건 갑자기 생긴 의문)
    @Transactional
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }


    public String saveUserKakaoAndGetToken(String token) {
        KakaoProfile profile = findKakaoProfile(token);

        User user = userRepository.findBySocialIdAndIsKakaoUser(profile.getId(), true);

        if (user == null) {
            user = User.builder()
                    .isKakaoUser(true)
                    .isNaverUser(false)
                    .name(profile.getName())
                    .socialId(profile.getId())
                    .build();
            userRepository.save(user);
        }
        return createJwtToken(user);
    }


    public KakaoProfile findKakaoProfile(String token) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        ResponseEntity<String> kakaoProfileResponse = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

//        System.out.println("kakaoProfileResponse.getBody() = " + kakaoProfileResponse.getBody());  // 썡 Json 테스트용 출력

        ObjectMapper objectMapper = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper.readValue(kakaoProfileResponse.getBody(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return kakaoProfile;
    }


    public String createJwtToken(User user) {
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .withClaim("id", user.getId())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));
    }

    public String saveUserNaverAndGetToken(String token) {
        NaverProfile profile = findNaverProfile(token);

        User user = userRepository.findBySocialIdAndIsNaverUser(profile.getId(), true);

        if (user == null) {
            user = User.builder()
                    .isNaverUser(true)
                    .isKakaoUser(false)
                    .socialId(profile.getId())
                    .name(profile.getName())
                    .email(profile.getEmail())
                    .build();
            userRepository.save(user);
        }
        return createJwtToken(user);
    }

    private NaverProfile findNaverProfile(String token) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> naverProfileRequest = new HttpEntity<>(headers);

        ResponseEntity<String> naverProfileResponse = rt.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.POST,
                naverProfileRequest,
                String.class
        );


        ObjectMapper objectMapper = new ObjectMapper();
        NaverProfile naverProfile = null;

        try {
            naverProfile = objectMapper.readValue(naverProfileResponse.getBody(), NaverProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return naverProfile;
    }
}
