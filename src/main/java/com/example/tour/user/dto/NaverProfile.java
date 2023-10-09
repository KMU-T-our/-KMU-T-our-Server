package com.example.tour.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverProfile {
    public String id;
    public String email;
    public String name;

    @JsonProperty("response")
    public void unpackNested(Map<String, Object> response) {
        this.id = (String) response.get("id");
        this.email = (String) response.get("email");
        this.name = (String) response.get("name");
    }
}
