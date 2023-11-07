package com.example.tour.load.loaduser.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoadUserSaveRequest {
    Long loadId;
    List<Long> users;
}
