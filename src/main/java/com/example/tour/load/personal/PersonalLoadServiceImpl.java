package com.example.tour.load.personal;

import com.example.tour.config.middletable.projectuser.ProjectUser;
import com.example.tour.config.middletable.projectuser.ProjectUserRepository;
import com.example.tour.load.personal.domain.PersonalLoad;

import com.example.tour.load.personal.dto.PersonalLoadRequest;
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
    public void savePersonalLoad(PersonalLoadRequest request){
        ProjectUser projectUser = projectUserRepository.findProjectUserByIdUserIdAndProjectId(request.getProject_id(), request.getUser_id());
        PersonalLoad personalLoad = new PersonalLoad(request, projectUser);
        personalLoadRepository.save(personalLoad);
    }

    @Transactional
    public List<PersonalLoad> getPersonalLoad() {return personalLoadRepository.findAll();}

    @Transactional
    public void updaterPersonalLoad(PersonalLoadRequest request){
        PersonalLoad personalLoad = personalLoadRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        personalLoad.updatePersonalLoad(request);
    }

    @Transactional
    public void deletePersonalLoad(String name){
        PersonalLoad personalLoad = personalLoadRepository.findByName(name)
                .orElseThrow(IllegalAccessError::new);

        personalLoadRepository.delete(personalLoad);
    }
}
