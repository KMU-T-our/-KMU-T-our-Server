package com.example.tour.service.user;

import com.example.tour.user.dto.NaverProfile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonParseTest {

    @Test
    public void jsonParse() {

        String json = "{\"resultcode\":\"00\",\"message\":\"success\",\"response\":{\"id\":\"PZMidofLvSPpDFOl0sq4ziO5mGNuFCA83EPSbRorkgA\",\"email\":\"munhwas1140@naver.com\",\"name\":\"\\ub178\\ud615\\uc900\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        NaverProfile naverProfile = null;
        try {
            naverProfile = objectMapper.readValue(json, NaverProfile.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(naverProfile.getId()).isEqualTo("PZMidofLvSPpDFOl0sq4ziO5mGNuFCA83EPSbRorkgA");
        assertThat(naverProfile.getName()).isEqualTo("노형준");
    }
}
