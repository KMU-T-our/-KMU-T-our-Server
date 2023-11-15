package com.example.tour.wallet.spending.dto.response;

import com.example.tour.wallet.spending.domain.Spending;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SpendingSaveResponse {
    private Long spendingId;
    private Long projectUserId;
    private String spendingTitle;
    private Spending.SpendingTag spendingTag;
    private long spendingAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate spendingDate;

    public SpendingSaveResponse(Long projectUserId, Spending spending){
        this.projectUserId = projectUserId;
        this.spendingId = spending.getWalletSpendingId();
        this.spendingTitle = spending.getWalletSpendingTitle();
        this.spendingAmount = spending.getWalletSpendingAmount();
        this.spendingDate = spending.getWalletSpendingDate();
        this.spendingTag = spending.getWalletSpendingTag();
    }
}
