package com.dima.financeapp.model.dto;

import com.dima.financeapp.model.Record;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
public class RecordDto {

    private Long id;
    private String name;
    private float sum;
    private String type;
    @JsonProperty("bill_name")
    private String billName;
    private int color;
    private int icon;
    private long date;
    private String info;

    public static RecordDto from(Record record) {
        RecordDto recordDto = new RecordDto();
        recordDto.setId(record.getId());
        recordDto.setName(record.getName());
        recordDto.setSum(record.getSum());
        recordDto.setType(record.getType());
        recordDto.setBillName(record.getBillName());
        recordDto.setIcon(record.getIcon());

        LocalDateTime ldt = record.getDate();
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("Europe/Moscow"));
        long millis = zdt.toInstant().toEpochMilli();

        recordDto.setDate(millis);
        recordDto.setInfo(record.getInfo());
        return recordDto;
    }
}
