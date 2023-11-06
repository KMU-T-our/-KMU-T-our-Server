package com.example.tour.wallet.spending;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.wallet.spending.domain.Spending;
import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import com.example.tour.wallet.spending.dto.response.SpendingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SpendingService {
    private final SpendingRepository spendingRepository;
    private final ProjectUserRepository projectUserRepository;
    @Transactional
    public void saveSpending(SpendingCreateRequest request) {
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(request.getProjectUserId());
        spendingRepository.save(new Spending(request, projectUser));
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getEntireSpending(Long projectUserId){
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(projectUserId);
        return spendingRepository.findByProjectUser(projectUser).stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getFilteringTagSpending(Long projectUserId, Spending.SpendingTag tag){
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(projectUserId);
        return spendingRepository.findByProjectUserAndWalletSpendingTag(projectUser, tag).stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getFilteringDateSpending(Long projectUserId, String date){
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(projectUserId);
        return spendingRepository.findByProjectUserAndWalletSpendingDate(projectUser,date).stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional
    public void updateSpending(SpendingUpdateRequest request){
        Spending spending = spendingRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        spending.updateSpending(request);
    }

    @Transactional
    public void deleteSpending(Long id){
        Spending spending = spendingRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        spendingRepository.delete(spending);

    }
}
