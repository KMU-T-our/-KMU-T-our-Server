package com.example.tour.wallet.spending.dto.response;

import com.example.tour.wallet.spending.domain.Spending;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SpendingResponse {
    private long spendingId;
    private String spendingTitle;
    private Spending.SpendingTag spendingTag;
    private long spendingAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate spendingDate;

    public SpendingResponse(Spending spending) {
        this.spendingId = spending.getWalletSpendingId();
        this.spendingTitle = spending.getWalletSpendingTitle();
        this.spendingTag = spending.getWalletSpendingTag();
        this.spendingAmount = spending.getWalletSpendingAmount();
        this.spendingDate = spending.getWalletSpendingDate();
    }

}
