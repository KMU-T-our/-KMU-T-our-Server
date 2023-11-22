package com.example.tour.wallet.spending.dto.request;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SpendingUpdateRequest {

    private Long id;
    private String title;
    private Spending.SpendingTag tag;
    private Long amount;
    private String date;

}
