package com.example.tour.wallet.spending.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpendingResponse {
    private long id;
    private String title;
    private int tag;
    private long amount;
    private String date;
}
