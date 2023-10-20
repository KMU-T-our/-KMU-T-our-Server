package com.example.tour.wallet.spending.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpendingCreateRequest {
    private String title;
    private int tag;
    private long amount;
    private String date;
}
