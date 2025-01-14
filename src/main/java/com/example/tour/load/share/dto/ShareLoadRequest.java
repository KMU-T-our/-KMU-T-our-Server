package com.example.tour.load.share.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShareLoadRequest {
    private Long id;
    private Long projectId;
    private String name;
    private boolean checkbox;
}
