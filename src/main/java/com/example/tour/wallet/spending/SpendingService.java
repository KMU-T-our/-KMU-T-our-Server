package com.example.tour.wallet.spending;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.wallet.spending.domain.Spending;
import com.example.tour.wallet.spending.dto.request.SpendingCreateRequest;
import com.example.tour.wallet.spending.dto.request.SpendingUpdateRequest;
import com.example.tour.wallet.spending.dto.response.SpendingResponse;
import com.example.tour.wallet.spending.dto.response.SpendingSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SpendingService {
    private final SpendingRepository spendingRepository;
    private final ProjectUserRepository projectUserRepository;
    @Transactional
    public SpendingSaveResponse saveSpending(SpendingCreateRequest request) {
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(request.getProjectUserId());
        Spending spending = new Spending(request, projectUser);
        spendingRepository.save(spending);
        return new SpendingSaveResponse(projectUser.getProjectUserId(), spending);
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getSpendingAll(Long projectUserId){
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(projectUserId);
        return spendingRepository.findByProjectUser(projectUser).stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getFilteringByTag(Long projectUserId, List<Spending.SpendingTag> tags){
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(projectUserId);
        return spendingRepository.findByProjectUserAndWalletSpendingTagIn(projectUser, tags).stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SpendingResponse> getFilteringByDate(Long projectUserId, LocalDate date){
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(projectUserId);
        return spendingRepository.findByProjectUserAndWalletSpendingDate(projectUser,date).stream()
                .map(SpendingResponse::new).collect(Collectors.toList());
    }

    @Transactional
    public void updateSpending(SpendingUpdateRequest request){
        Spending spending = spendingRepository.findById(request.getSpendingId())
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
