package com.example.tour.wallet.spending.dto.response;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpendingResponse {
    private Long spendingId;
    private String title;
    private Spending.SpendingTag tag;
    private Long amount;
    private String date;

    public SpendingResponse(Spending spending) {
        this.spendingId = spending.getWalletSpendingId();
        this.title = spending.getWalletSpendingTitle();
        this.tag = spending.getWalletSpendingTag();
        this.amount = spending.getWalletSpendingAmount();
        this.date = spending.getWalletSpendingDate();
    }

}
