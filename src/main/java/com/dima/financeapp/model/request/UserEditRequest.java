package com.dima.financeapp.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserEditRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    @JsonProperty("photo_url")
    private String photoUrl;
    private String datebirth;
    private String gender;
}
