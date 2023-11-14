package com.example.tour.load.personal.dto;

import com.example.tour.load.personal.domain.PersonalLoad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalLoadResponse {
    private Long id;
    private String name;
    private boolean checkbox;
    private Long project_user_id;

    public PersonalLoadResponse(PersonalLoad personalLoad){
        this.id = personalLoad.getId();
        this.name = personalLoad.getName();
        this.project_user_id = personalLoad.getProjectUser().getProjectUserId();
        this.checkbox = isCheckbox();
    }
}
