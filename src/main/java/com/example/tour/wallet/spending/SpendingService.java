package com.example.tour.wallet.spending;

import com.example.tour.wallet.spending.domain.Spending;
import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import com.example.tour.wallet.spending.dto.response.SpendingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpendingService {
    //    private final SpendingRepository spendingRepository;
    private final SpendingRepositoryJpa spendingRepository;

    public void saveSpending(SpendingCreateRequest request) {
//        spendingRepository.saveSpending(request.getTitle(),request.getTag(), request.getAmount(), request.getDate());
        spendingRepository.save(new Spending(request));

    }

    public List<SpendingResponse> getEntireSpending(){
//        return spendingRepository.getEntireSpending();
        return spendingRepository.findAll().stream()
                .map(SpendingResponse::new)
                .toList();
    }
    public List<SpendingResponse> getFilteringTagSpending(int tag){
//        return spendingRepository.getFilteringTagSpending(tag);
        return spendingRepository.findByWalletSpendingTag(tag).stream()
                .map(SpendingResponse::new)
                .toList();
    }

    public List<SpendingResponse> getFilteringDateSpending(String date){
//        return spendingRepository.getFilteringDateSpending(date);
        return spendingRepository.findByWalletSpendingDate(date).stream()
                .map(SpendingResponse::new)
                .toList();
    }

    public void updateSpending(SpendingUpdateRequest request){
//        spendingRepository.updateSpending(request.getId(), request.getTitle(), request.getTag(), request.getAmount(), request.getDate());
        spendingRepository.save(new Spending(request));
    }

    public void deleteSpending(@RequestParam long id) {
        spendingRepository.deleteById(id);
    }
}
