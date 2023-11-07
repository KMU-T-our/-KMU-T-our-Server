package com.example.tour.wallet.spending.dto.request;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SpendingCreateRequest {
    private String title;
    private Spending.SpendingTag tag;
    private Long amount;
    private String date;
    private Long projectUserId;
}
