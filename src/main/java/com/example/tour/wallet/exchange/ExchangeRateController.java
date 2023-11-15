package com.example.tour.wallet.exchange;

import com.example.tour.wallet.exchange.dto.ExchangeRateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/api/exchange")
    public List<ExchangeRateResponse> callExchangeApi(
            @RequestParam(value="searchDate", required = false) String searchDate
    ){
        return exchangeRateService.callExchangeApi(searchDate);
    }
}
