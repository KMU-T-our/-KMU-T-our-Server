package com.example.tour.wallet.spending.dto.request;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;

@Getter
public class SpendingCreateRequest {
    private String title;
    private Spending.SpendingTag tag;
    private long amount;
    private String date;

    public SpendingCreateRequest(String title, Spending.SpendingTag tag, Long amount, String date) {
        this.title = title;
        this.tag = tag;
        this.amount = amount;
        this.date = date;
    }

}
