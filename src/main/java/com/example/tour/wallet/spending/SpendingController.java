package com.example.tour.wallet.spending;

import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import com.example.tour.wallet.spending.dto.response.SpendingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpendingController {

    private final SpendingService spendingService;

    @PostMapping("/api/wallet/spending")
    public void saveWalletSpending(@RequestBody SpendingCreateRequest request){
        spendingService.saveSpending(request);
    }

    @GetMapping("/api/wallet/spending/entire")
    public List<SpendingResponse> getWalletEntireSpending(){
        return spendingService.getEntireSpending();
    }

    @GetMapping("/api/wallet/spending/tag")
    public List<SpendingResponse> getWalletFilteringTagSpending(@RequestParam int tag){
        return spendingService.getFilteringTagSpending(tag);
    }

    @GetMapping("/api/wallet/spending/date")
    public List<SpendingResponse> getWalletFilteringDateSpending(@RequestParam String date){
        return spendingService.getFilteringDateSpending(date);
    }

    @PutMapping("/api/wallet/spending")
    public void updateSpending(@RequestBody SpendingUpdateRequest request){
        spendingService.updateSpending(request);
    }

    @DeleteMapping("/api/wallet/spending")
    public void deleteSpending(@RequestParam long id){
        spendingService.deleteSpending(id);
    }

}

