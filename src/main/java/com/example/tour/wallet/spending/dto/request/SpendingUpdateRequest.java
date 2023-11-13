package com.example.tour.wallet.spending.dto.request;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SpendingUpdateRequest {

    private long spendingId;
    private String spendingTitle;
    private Spending.SpendingTag spendingTag;
    private long spendingAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate spendingDate;

}
