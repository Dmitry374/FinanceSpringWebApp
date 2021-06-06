package com.dima.financeapp.service;

import com.dima.financeapp.common.Constants;
import com.dima.financeapp.model.Bill;
import com.dima.financeapp.model.Record;
import com.dima.financeapp.model.exception.RecordNotFoundException;
import com.dima.financeapp.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RecordService {

    private final BillService billService;
    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository, BillService billService) {
        this.recordRepository = recordRepository;
        this.billService = billService;
    }

    @Transactional
    public Record addRecord(Record newRecord, Long billId) {
        Record record = recordRepository.save(newRecord);
        Bill bill = billService.getBill(billId);

        switch (newRecord.getType()) {
            case Constants.RECORD_TYPE_INCOME:
                bill.setAmount(bill.getAmount() + record.getSum());
                break;
            case Constants.RECORD_TYPE_CONSUMPTION:
                bill.setAmount(bill.getAmount() - record.getSum());
                break;
        }

        bill.addRecord(record);
        return record;
    }

    @Transactional
    public Record deleteRecord(Long id) {
        Record record = getRecord(id);
        recordRepository.delete(record);
        return record;
    }

    @Transactional
    public Record editRecord(Long id, Record record) {
        Record recordToEdit = getRecord(id);
        recordToEdit.setName(record.getName());
        recordToEdit.setSum(record.getSum());
        recordToEdit.setType(record.getType());
        recordToEdit.setBillName(record.getBillName());
        recordToEdit.setIcon(record.getIcon());
        recordToEdit.setDate(record.getDate());
        return recordToEdit;
    }

    public Record getRecord(Long id) {
        return recordRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException(id));
    }
}
