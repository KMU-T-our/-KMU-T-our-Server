package com.example.tour.wallet.spending.dto.request;

import lombok.Getter;

@Getter
public class SpendingUpdateRequest {

    private long id;
    private String title;
    private int tag;
    private long amount;
    private String date;

}
