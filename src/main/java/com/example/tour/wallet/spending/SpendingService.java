package com.example.tour.wallet.spending;

import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import com.example.tour.wallet.spending.dto.response.SpendingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpendingService {
    private final SpendingRepository spendingRepository;

    public void saveSpending(SpendingCreateRequest request) {
        spendingRepository.saveSpending(request.getTitle(),request.getTag(), request.getAmount(), request.getDate());
    }

    public List<SpendingResponse> getEntireSpending(){
        return spendingRepository.getEntireSpending();
    }
    public List<SpendingResponse> getFilteringTagSpending(int tag){
        return spendingRepository.getFilteringTagSpending(tag);
    }

    public List<SpendingResponse> getFilteringDateSpending(String date){
        return spendingRepository.getFilteringDateSpending(date);
    }

    public void updateSpending(SpendingUpdateRequest request){
        if(spendingRepository.isSpendingExist(request.getId())){
            throw new IllegalArgumentException();
        }
        spendingRepository.updateSpending(request.getId(), request.getTitle(), request.getTag(), request.getAmount(), request.getDate());
    }

    public void deleteSpending(long id){
        if(spendingRepository.isSpendingExist(id)){
            throw new IllegalArgumentException();
        }
        spendingRepository.deleteUser(id);
    }
}
