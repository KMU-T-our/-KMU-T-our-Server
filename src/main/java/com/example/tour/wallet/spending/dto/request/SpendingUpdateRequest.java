package com.example.tour.wallet.spending.dto.request;

import com.example.tour.wallet.spending.domain.Spending;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SpendingUpdateRequest {

    private long id;
    private String title;
    private Spending.SpendingTag tag;
    private long amount;
    private String date;

}
