package com.example.tour.load.share.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShareLoadSaveRequest {
    private Long projectId;
    private String name;
    private boolean checkbox;
}
