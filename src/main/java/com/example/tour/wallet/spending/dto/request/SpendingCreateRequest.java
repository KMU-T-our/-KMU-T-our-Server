package com.example.tour.wallet.spending.dto.request;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
public class SpendingCreateRequest {
    private String title;
    private Spending.SpendingTag tag;
    private Long amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long projectUserId;
}
