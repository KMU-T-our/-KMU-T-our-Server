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

    @Transactional
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }


    /**
     * 카카오 액세스 토큰을 이용해서 유저정보를 가져오고
     * 디비에 해당 유저가 없다면 새로 만들고 있다면 그 유저를 이용해 jwt를 만들어 리턴하는 함수
     */
    public ResponseEntity<User> saveUserKakaoAndGetToken(String token) {
        // 액세스토큰을 이용하여 카카오에서 회원 Json을 받아오고 필요한 정보만 KakaoProfile에 매핑해준다.
        KakaoProfile profile = findKakaoProfile(token);

        // KakaoProfile의 소셜아이디로 디비에서 유저를 찾는다.
        User user = userRepository.findBySocialIdAndType(profile.getId(), "kakao");

        // 만약 해당 소셜아이디를 가진 유저가 없다면 새로 만든다.
        if (user == null) {
            user = User.builder()
                    .type("kakao")
                    .name(profile.getName())
                    .socialId(profile.getId())
                    .build();
            userRepository.save(user);
        }

        // 디비에서 찾았거나 새로 만든 유저로 토큰을만들어 반환한다.
        return makeResponseEntity(user);
    }


    // 토큰을 이용하여 카카오 회원 서버에서 정보를 가져온 후, KakaoProfile에 매핑해주는 함수.
    public KakaoProfile findKakaoProfile(String token) {
        RestTemplate rt = new RestTemplate(); // http요청을 위한 템플릿 ? 뭔지 잘 모름


        // HTTP 요청 헤더
        // 기본적인 헤더에 인증 헤더를 추가하여 헤더를 만든다.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");



        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        //실제 HTTP 요청 부분
        ResponseEntity<String> kakaoProfileResponse = rt.exchange(
                "https://kapi.kakao.com/v2/user/me", // 요청 URL
                HttpMethod.POST, // HTTP 메서드
                kakaoProfileRequest, // HTTP 헤더
                String.class // response받을 타입
        );


        System.out.println("kakaoProfileResponse.getBody() = " + kakaoProfileResponse.getBody());  // 썡 Json 테스트용 출력


        // Json을 kakaoProfile에 매핑해주기 위한 오브젝트 매퍼
        ObjectMapper objectMapper = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper.readValue(kakaoProfileResponse.getBody(), KakaoProfile.class); // 매핑
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return kakaoProfile;
    }


    // 네이버도 위쪽을 카카오 로직과 똑같다.
    public ResponseEntity<User> saveUserNaverAndGetToken(String token) {
        NaverProfile profile = findNaverProfile(token);

        User user = userRepository.findBySocialIdAndType(profile.getId(), "naver");

        if (user == null) {
            user = User.builder()
                    .type("kakao")
                    .socialId(profile.getId())
                    .name(profile.getName())
                    .email(profile.getEmail())
                    .build();
            userRepository.save(user);
        }
        return makeResponseEntity(user);
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

    public ResponseEntity<User> makeResponseEntity(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + createJwtToken(user));
        return ResponseEntity.ok().headers(headers).body(user);
    }

    // user 와 java-jwt를 이용하여 jwt생성
    // 클레임에 id만 넣었다.
    public String createJwtToken(User user) {
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .withClaim("id", user.getId())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));
    }
}
