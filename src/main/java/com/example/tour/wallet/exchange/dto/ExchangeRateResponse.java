package com.example.tour.wallet.exchange.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateResponse {
    @JsonProperty("cur_unit")
    private String curUnit; // 통화 코드

    @JsonProperty("cur_nm")
    private String curName; // 국가/통화명

    @JsonProperty("deal_bas_r")
    private String dealBasRate; // 매매 기준율

}

