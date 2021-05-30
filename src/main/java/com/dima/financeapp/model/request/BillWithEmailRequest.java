package com.dima.financeapp.model.request;

import lombok.Data;

@Data
public class BillWithEmailRequest {
    private String name;
    private float amount;
    private int color;
    private String email;
}
