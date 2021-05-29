package com.dima.financeapp.model;

import com.dima.financeapp.model.dto.BillDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float amount;
    private int color;
    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    private List<Record> records = new ArrayList<>();

    public void addRecord(Record record) {
        records.add(record);
    }

    public void removeRecord(Record record) {
        records.remove(record);
    }

    public static Bill from(BillDto billDto) {
        Bill bill = new Bill();
        bill.setName(billDto.getName());
        bill.setAmount(billDto.getAmount());
        bill.setColor(bill.getColor());
        return bill;
    }
}
