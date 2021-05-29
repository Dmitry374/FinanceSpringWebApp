package com.dima.financeapp.model.dto;

import com.dima.financeapp.model.Record;
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
    private int color;
    private int icon;
    private long date;

    public static RecordDto from(Record record) {
        RecordDto recordDto = new RecordDto();
        recordDto.setId(record.getId());
        recordDto.setName(record.getName());
        recordDto.setSum(record.getSum());
        recordDto.setType(record.getType());
        recordDto.setColor(record.getColor());
        recordDto.setIcon(record.getIcon());

        LocalDateTime ldt = record.getDate();
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("Europe/Moscow"));
        long millis = zdt.toInstant().toEpochMilli();

        recordDto.setDate(millis);
        return recordDto;
    }
}
