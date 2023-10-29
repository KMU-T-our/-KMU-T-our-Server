package com.example.tour.load.personal.dto;



import com.example.tour.config.middletable.projectuser.ProjectUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonalLoadRequest {
    private Long id;
    private String name;
    private boolean checkbox;
    private ProjectUser projectUser;
}
