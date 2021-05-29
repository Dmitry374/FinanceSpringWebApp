package com.dima.financeapp.model.dto;

import com.dima.financeapp.model.Bill;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class BillDto {

    private Long id;
    private String name;
    private float amount;
    private int color;
    @JsonProperty("records")
    private List<RecordDto> recordsDto = new ArrayList<>();

    public static BillDto from(Bill bill) {
        BillDto billDto = new BillDto();
        billDto.setId(bill.getId());
        billDto.setName(bill.getName());
        billDto.setAmount(bill.getAmount());
        billDto.setColor(bill.getColor());
        billDto.setRecordsDto(bill.getRecords().stream().map(RecordDto::from).collect(Collectors.toList()));
        return billDto;
    }
}
