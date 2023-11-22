package com.example.tour.wallet.exchange;

import com.example.tour.wallet.exchange.dto.ExchangeRateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/api/exchange")
    public List<ExchangeRateResponse> getExchangeRate(
            @RequestParam(value="searchDate", required = false) String searchDate
    ){
        LocalDate date = LocalDate.now();
        if (searchDate != null) {
            date = LocalDate.parse(searchDate);
        }

        LocalTime time = LocalTime.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        // 시간이 오전 11시 이전이면 날짜를 하루 전으로 변경
        if (time.isBefore(LocalTime.of(11, 0))) {
            date = date.minusDays(1);
        }

        // 토요일 또는 일요일인 경우 해당 주의 금요일로 변경
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            date = date.minusDays(dayOfWeek == DayOfWeek.SATURDAY ? 1 : 2);
        }

        return exchangeRateService.getExchangeRate(date.toString());

    }
}
