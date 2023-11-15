package com.example.tour.wallet.spending.dto.response;

import com.example.tour.wallet.spending.domain.Spending;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SpendingSaveResponse {
    private Long id;
    private Long projectUserId;
    private String title;
    private Spending.SpendingTag tag;
    private long amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate date;

    public SpendingSaveResponse(Long projectUserId, Spending spending){
        this.projectUserId = projectUserId;
        this.id = spending.getWalletSpendingId();
        this.title = spending.getWalletSpendingTitle();
        this.amount = spending.getWalletSpendingAmount();
        this.date = spending.getWalletSpendingDate();
        this.tag = spending.getWalletSpendingTag();
    }
}
