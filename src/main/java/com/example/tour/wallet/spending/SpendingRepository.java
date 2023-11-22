package com.example.tour.wallet.spending;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.wallet.spending.domain.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Long> {
    List<Spending> findByProjectUser(ProjectUser projectUser);
    List<Spending> findByProjectUserAndWalletSpendingTagIn(ProjectUser projectUser, List<Spending.SpendingTag> tag);
    List<Spending> findByProjectUserAndWalletSpendingDate(ProjectUser projectUser, String walletSpendingDate);
}

