package com.example.tour.load.personal.dto;


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
    private Long project_id;
    private Long user_id;
}
