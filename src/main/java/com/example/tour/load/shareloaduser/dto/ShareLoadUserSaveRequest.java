package com.example.tour.load.shareloaduser.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShareLoadUserSaveRequest {
    Long loadId;
    List<Long> users;
}
