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
        if(request.getSpendingAmount() == 0){
            throw new IllegalArgumentException();
        }
        this.walletSpendingTitle = request.getSpendingTitle();
        this.walletSpendingTag = request.getSpendingTag();
        this.walletSpendingAmount = request.getSpendingAmount();
        this.walletSpendingDate = request.getSpendingDate();
        this.projectUser = projectUser;
    }
    public void updateSpending(SpendingUpdateRequest request) {
        if(request.getSpendingTitle() != null) {this.walletSpendingTitle = request.getSpendingTitle();}
        if(request.getSpendingTag() != null) {this.walletSpendingTag = request.getSpendingTag();}
        if(request.getSpendingAmount() != 0) {this.walletSpendingAmount = request.getSpendingAmount();}
        if(request.getSpendingDate() != null) {this.walletSpendingDate = request.getSpendingDate();}
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
