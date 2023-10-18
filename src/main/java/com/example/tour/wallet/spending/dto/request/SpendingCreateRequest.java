package com.example.tour.wallet.spending.dto.request;

import lombok.Getter;

@Getter
public class SpendingCreateRequest {
    private String title;
    private int tag;
    private long amount;
    private String date;

    public SpendingCreateRequest(String title, int tag, Long amount, String date) {
        this.title = title;
        this.tag = tag;
        this.amount = amount;
        this.date = date;
    }

}
