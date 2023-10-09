package com.example.tour.user.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoProfile {
    public String id;
    public String name;

    @JsonProperty("properties")
    public void unpackNested(Map<String, Object> response) {
        this.name = (String) response.get("nickname");
    }
}