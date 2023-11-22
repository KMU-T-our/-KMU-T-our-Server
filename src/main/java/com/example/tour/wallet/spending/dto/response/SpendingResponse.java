package com.example.tour.wallet.spending.dto.response;

import com.example.tour.wallet.spending.domain.Spending;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SpendingResponse {
    private long id;
    private String title;
    private Spending.SpendingTag tag;
    private long amount;
    private String date;

    public SpendingResponse(Spending spending) {
        this.id = spending.getWalletSpendingId();
        this.title = spending.getWalletSpendingTitle();
        this.tag = spending.getWalletSpendingTag();
        this.amount = spending.getWalletSpendingAmount();
        this.date = spending.getWalletSpendingDate();
    }

}
