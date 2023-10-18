package com.example.tour.wallet.spending.domain;

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
    private long wallet_spending_id;

    @Column
    private String wallet_spending_title;

    @Column
    private int wallet_spending_tag;

    @Column
    private long wallet_spending_amount;

    @Column
    private String wallet_spending_date;


}
