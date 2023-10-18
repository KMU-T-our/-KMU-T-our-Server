package com.example.tour.wallet.spending.dto.response;

import lombok.Getter;

@Getter
public class SpendingResponse {
    private long id;
    private String title;
    private int tag;
    private long amount;
    private String date;

    public SpendingResponse(long id, String title, int tag, long amount, String date) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.amount = amount;
        this.date = date;
    }

}
