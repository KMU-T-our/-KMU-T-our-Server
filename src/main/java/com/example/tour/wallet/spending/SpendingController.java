package com.example.tour.wallet.spending;

import com.example.tour.wallet.spending.domain.Spending;
import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import com.example.tour.wallet.spending.dto.response.SpendingResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SpendingController {

    private final SpendingService spendingService;

    @PostMapping("/api/wallet/spending")
    public SpendingResponse saveSpending(@RequestBody SpendingCreateRequest request){
        return spendingService.saveSpending(request);
    }

    @GetMapping("/api/wallet/spending/all")
    public List<SpendingResponse> getSpendingAll(@RequestParam Long projectUserId){
        return spendingService.getSpendingAll(projectUserId);
    }

    @GetMapping("/api/wallet/spending/tag")
    public List<SpendingResponse> getSpendingFilteringByTag(@RequestParam Long projectUserId, @RequestParam List<String> tags){
        List<Spending.SpendingTag> spendingTags = tags.stream()
                .map(Spending.SpendingTag::valueOf)
                .collect(Collectors.toList());
        return spendingService.getFilteringByTag(projectUserId, spendingTags);
    }

    @GetMapping("/api/wallet/spending/date")
    public List<SpendingResponse> getSpendingFilteringByDate(@RequestParam Long projectUserId, @RequestParam String date){
        return spendingService.getFilteringByDate(projectUserId, date);
    }

    @PatchMapping("/api/wallet/spending")
    public SpendingResponse updateSpending(@RequestBody SpendingUpdateRequest request){
        return spendingService.updateSpending(request);
    }

    @DeleteMapping("/api/wallet/spending")
    public void deleteSpending(@RequestParam long id){
        spendingService.deleteSpending(id);
    }

}

