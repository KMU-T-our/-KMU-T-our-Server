package com.example.tour.wallet.spending.domain;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "WALLET_SPENDING")
@Entity
@NoArgsConstructor
@Builder
public class Spending {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "wallet_spending_id")
    private Long walletSpendingId;

    @Column(name = "wallet_spending_title")
    private String walletSpendingTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "wallet_spending_tag")
    private SpendingTag walletSpendingTag;

    @Column(name = "wallet_spending_amount")
    private Long walletSpendingAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "wallet_spending_date")
    private LocalDate walletSpendingDate;

    // ProjectUser와 단방향 매핑
    @ManyToOne
    @JoinColumn(name = "project_user_id", nullable = false)
    private ProjectUser projectUser;

    public Spending(SpendingCreateRequest request, ProjectUser projectUser) {
        if(request.getAmount() == 0){
            throw new IllegalArgumentException();
        }
        this.walletSpendingTitle = request.getTitle();
        this.walletSpendingTag = request.getTag();
        this.walletSpendingAmount = request.getAmount();
        this.walletSpendingDate = request.getDate();
        this.projectUser = projectUser;
    }
    public void updateSpending(SpendingUpdateRequest request) {
        if(request.getTitle() != null) {this.walletSpendingTitle = request.getTitle();}
        if(request.getTag() != null) {this.walletSpendingTag = request.getTag();}
        if(request.getAmount() != 0) {this.walletSpendingAmount = request.getAmount();}
        if(request.getDate() != null) {this.walletSpendingDate = request.getDate();}
    }

    public enum SpendingTag {
        ETC,
        FOOD,
        GIFT,
        TRANSIT,
        TOUR,
        HOME
    }



}
