package com.dima.financeapp.model;

import com.dima.financeapp.model.dto.RecordDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float sum;
    private String type;
    private int color;
    private int icon;
    private LocalDateTime date;
    @ManyToOne
    private Bill bill;

    public static Record from(RecordDto recordDto) {
        Record record = new Record();
        record.setName(recordDto.getName());
        record.setSum(record.getSum());
        record.setType(record.getType());
        record.setColor(recordDto.getColor());
        record.setIcon(recordDto.getIcon());
        record.setDate(record.getDate());
        return record;
    }
}
