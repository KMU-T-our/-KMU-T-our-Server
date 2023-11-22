package com.example.tour.wallet.exchange.domain;

import com.example.tour.wallet.exchange.dto.ExchangeRateResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ExchangeRate {
    private String searchDate;
    private List<ExchangeRateResponse> exchangeRateList;

    public ExchangeRate(String searchDate, List<ExchangeRateResponse> result) {
        this.searchDate = searchDate;
        this.exchangeRateList = result;
    }
}
