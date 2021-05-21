package com.dima.financeapp.model.request;

import lombok.Data;

@Data
public class AuthUser {
    private String email;
    private String password;
}
