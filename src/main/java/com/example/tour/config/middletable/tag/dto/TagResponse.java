package com.example.tour.config.middletable.tag.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagResponse {
    public Long tagId;

    public TagResponse(Long tagId) {
        this.tagId = tagId;
    }
}
