package com.dima.financeapp.controller;

import com.dima.financeapp.model.Record;
import com.dima.financeapp.model.dto.RecordDto;
import com.dima.financeapp.model.request.RecordWithBillId;
import com.dima.financeapp.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/add")
    public ResponseEntity<RecordDto> addRecord(@RequestBody RecordWithBillId recordWithBillId) {
        Record record = recordService.addRecord(Record.from(recordWithBillId), recordWithBillId.getBillId());
        return new ResponseEntity<>(RecordDto.from(record), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<RecordDto> deleteRecord(@PathVariable final Long id) {
        Record record = recordService.deleteRecord(id);
        return new ResponseEntity<>(RecordDto.from(record), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<RecordDto> editRecord(@PathVariable final Long id,
                                                @RequestBody final RecordDto recordDto) {
        Record record = recordService.editRecord(id, Record.from(recordDto));
        return new ResponseEntity<>(RecordDto.from(record), HttpStatus.OK);
    }
}
