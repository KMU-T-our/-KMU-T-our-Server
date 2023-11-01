package com.example.tour.wallet.spending;

import com.example.tour.wallet.spending.domain.Spending;
import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import com.example.tour.wallet.spending.dto.response.SpendingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SpendingService {
    private final SpendingRepository spendingRepository;

    @Transactional
    public void saveSpending(SpendingCreateRequest request) {
        spendingRepository.save(new Spending(request));
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getEntireSpending(){
        return spendingRepository.findAll().stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getFilteringTagSpending(int tag){
        return spendingRepository.findByWalletSpendingTag(tag).stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getFilteringDateSpending(String date){
        return spendingRepository.findByWalletSpendingDate(date).stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional
    public void updateSpending(SpendingUpdateRequest request){
        Spending spending = spendingRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        spending.updateSpending(request);
    }

    @Transactional
    public void deleteSpending(long id){
        Spending spending = spendingRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        spendingRepository.delete(spending);

    }
}
