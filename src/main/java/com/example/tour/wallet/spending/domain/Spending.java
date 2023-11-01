package com.example.tour.wallet.spending.domain;

import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "WALLET_SPENDING")
@Entity
@NoArgsConstructor
@Builder
public class Spending {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long walletSpendingId;

    @Column
    private String walletSpendingTitle;

    @Enumerated(EnumType.STRING)
    @Column
    private SpendingTag walletSpendingTag;

    @Column
    private long walletSpendingAmount;

    @Column
    private String walletSpendingDate;

    public Spending(SpendingCreateRequest request) {
        this.walletSpendingTitle = request.getTitle();
        this.walletSpendingTag = request.getTag();
        this.walletSpendingAmount = request.getAmount();
        this.walletSpendingDate = request.getDate();
    }

    public Spending(SpendingUpdateRequest request) {
        this.walletSpendingTitle = request.getTitle();
        this.walletSpendingTag = request.getTag();
        this.walletSpendingAmount = request.getAmount();
        this.walletSpendingDate = request.getDate();
    }

    public void updateSpending(SpendingUpdateRequest request) {
        this.walletSpendingTitle = request.getTitle();
        this.walletSpendingTag = request.getTag();
        this.walletSpendingAmount = request.getAmount();
        this.walletSpendingDate = request.getDate();
    }

    public enum SpendingTag {
        기타,
        식당,
        선물,
        교통,
        관광,
        숙소
    }



}
