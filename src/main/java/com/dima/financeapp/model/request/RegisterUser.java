package com.dima.financeapp.model.request;

import lombok.Data;

@Data
public class RegisterUser {
    private String name;
    private String email;
    private String password;
}
