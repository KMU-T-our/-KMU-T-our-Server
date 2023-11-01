package com.example.tour.wallet.spending;

import com.example.tour.wallet.spending.domain.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Long> {
    List<Spending> findByWalletSpendingTag(int tag);

    List<Spending> findByWalletSpendingDate(String date);

}
