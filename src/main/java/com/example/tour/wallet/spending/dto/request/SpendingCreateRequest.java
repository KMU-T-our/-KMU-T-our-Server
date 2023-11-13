package com.example.tour.wallet.spending.dto.request;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
public class SpendingCreateRequest {
    private String spendingTitle;
    private Spending.SpendingTag spendingTag;
    private Long spendingAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate spendingDate;
    private Long projectUserId;
}
