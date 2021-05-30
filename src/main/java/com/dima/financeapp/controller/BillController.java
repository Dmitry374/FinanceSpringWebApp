package com.dima.financeapp.controller;

import com.dima.financeapp.model.Bill;
import com.dima.financeapp.model.dto.BillDto;
import com.dima.financeapp.model.request.BillWithEmailRequest;
import com.dima.financeapp.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/add")
    public ResponseEntity<BillDto> addBill(@RequestBody final BillWithEmailRequest billWithEmailRequest) {
        Bill bill = billService.addBill(Bill.from(billWithEmailRequest), billWithEmailRequest.getEmail());
        return new ResponseEntity<>(BillDto.from(bill), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<BillDto> deleteBill(@PathVariable final Long id) {
        Bill bill = billService.deleteBill(id);
        return new ResponseEntity<>(BillDto.from(bill), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<BillDto> editBill(@PathVariable final Long id,
                                            @RequestBody final BillDto billDto) {
        Bill bill = billService.editBill(id, Bill.from(billDto));
        return new ResponseEntity<>(BillDto.from(bill), HttpStatus.OK);
    }
}
