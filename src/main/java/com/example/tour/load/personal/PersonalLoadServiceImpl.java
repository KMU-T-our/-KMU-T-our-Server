package com.example.tour.load.personal;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.load.personal.domain.PersonalLoad;
import com.example.tour.load.personal.dto.PersonalLoadRequest;
import com.example.tour.load.personal.dto.PersonalLoadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PersonalLoadServiceImpl {

    private final PersonalLoadRepository personalLoadRepository;
    private final ProjectUserRepository projectUserRepository;

    @Transactional
    public PersonalLoadResponse savePersonalLoad(PersonalLoadRequest request){
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(request.getProject_user_id());
        PersonalLoad personalLoad = new PersonalLoad(request, projectUser);
        personalLoadRepository.save(personalLoad);
        return new PersonalLoadResponse(personalLoad);
    }

    @Transactional
    public List<PersonalLoadResponse> getAllPersonalLoad(Long projectUserId) {
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(projectUserId);
        return personalLoadRepository.findAllByProjectUser(projectUser).stream()
                .map(PersonalLoadResponse::new).toList();
    }

    @Transactional
    public PersonalLoadResponse getPersonalLoad(PersonalLoadRequest request){
        ProjectUser projectUser = projectUserRepository.findByProjectUserId(request.getProject_user_id());
        PersonalLoad personalLoad = personalLoadRepository.findByProjectUserAndId(projectUser, request.getId());
        PersonalLoadResponse personalLoadResponse = new PersonalLoadResponse(personalLoad);
        return personalLoadResponse;
    }

    @Transactional
    public void updaterPersonalLoad(PersonalLoadRequest request){
        PersonalLoad personalLoad = personalLoadRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        personalLoad.updatePersonalLoad(request);
    }

    @Transactional
    public void deletePersonalLoad(Long id){
        PersonalLoad personalLoad = personalLoadRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        personalLoadRepository.delete(personalLoad);
    }
}
