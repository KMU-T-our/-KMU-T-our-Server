package com.example.tour.wallet.exchange.domain;


// ExchangeRate 클래스 만들어서 String date 랑 List<Ex--- > 들어가게 해서 만들기

import com.example.tour.wallet.exchange.dto.ExchangeRateResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class ExchangeRate {
    private String searchDate;
    private List<ExchangeRateResponse> exchangeRateList;

    public ExchangeRate(String searchDate, List<ExchangeRateResponse> result) {
        this.searchDate = searchDate;
        this.exchangeRateList = result;
    }
}
