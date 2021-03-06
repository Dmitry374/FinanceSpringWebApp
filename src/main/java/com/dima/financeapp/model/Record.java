package com.dima.financeapp.model;

import com.dima.financeapp.model.dto.RecordDto;
import com.dima.financeapp.model.request.RecordWithBillId;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

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
    @Column(name = "bill_name")
    private String billName;
    private int icon;
    private LocalDateTime date;
    private String info;
    @Transient
    @ManyToOne
    private Bill bill;

    public static Record from(RecordDto recordDto) {
        Record record = new Record();
        record.setName(recordDto.getName());
        record.setSum(recordDto.getSum());
        record.setType(recordDto.getType());
        record.setBillName(recordDto.getBillName());
        record.setIcon(recordDto.getIcon());
        record.setDate(millisecondsToLocalDateTime(recordDto.getDate()));
        record.setInfo(recordDto.getInfo());
        return record;
    }

    public static Record from(RecordWithBillId recordWithBillId) {
        Record record = new Record();
        record.setName(recordWithBillId.getName());
        record.setSum(recordWithBillId.getSum());
        record.setType(recordWithBillId.getType());
        record.setBillName(recordWithBillId.getBillName());
        record.setIcon(recordWithBillId.getIcon());
        record.setDate(millisecondsToLocalDateTime(recordWithBillId.getDate()));
        record.setInfo(recordWithBillId.getInfo());
        return record;
    }

    private static LocalDateTime millisecondsToLocalDateTime(Long milliseconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds),
                TimeZone.getDefault().toZoneId());
    }
}
