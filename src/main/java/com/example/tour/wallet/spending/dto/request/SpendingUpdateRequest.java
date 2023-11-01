package com.example.tour.wallet.spending.dto.request;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;

@Getter
public class SpendingUpdateRequest {

    private long id;
    private String title;
    private Spending.SpendingTag tag;
    private long amount;
    private String date;

}
