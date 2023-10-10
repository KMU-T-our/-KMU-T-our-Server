package com.example.tour.wallet.exchange;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ExchangeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Open aPI 통신 테스트")
    public void callExchangeApi() throws Exception{
        String searchDate = "2023-10-10";

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();

        param.add("searchDate", searchDate);

        this.mvc.perform(get("/api/exchange").params(param)).andExpect(status().isOk()).andDo(print());
    }

}