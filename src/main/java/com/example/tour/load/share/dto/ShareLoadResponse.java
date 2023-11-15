package com.example.tour.load.share.dto;

import com.example.tour.load.share.domain.ShareLoad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShareLoadResponse {
    private Long id;
    private String name;
    private boolean checkbox;
    private Long projectId;

    public ShareLoadResponse(ShareLoad shareLoad){
        this.id = shareLoad.getId();
        this.name = shareLoad.getName();
        this.checkbox = shareLoad.isCheckbox();
        this.projectId = shareLoad.getProject().getId();
    }
}
