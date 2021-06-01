package com.dima.financeapp.model.request;

import lombok.Data;

@Data
public class RecordWithBillId {
    private Long id;
    private String name;
    private float sum;
    private String type;
    private int color;
    private int icon;
    private Long date;
    private Long billId;
}
