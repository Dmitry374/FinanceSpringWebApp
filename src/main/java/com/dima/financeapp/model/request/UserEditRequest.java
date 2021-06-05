package com.dima.financeapp.model.request;

import lombok.Data;

@Data
public class UserEditRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String datebirth;
    private String gender;
}
