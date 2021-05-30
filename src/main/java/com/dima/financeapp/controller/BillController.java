package com.dima.financeapp.controller;

import com.dima.financeapp.model.Bill;
import com.dima.financeapp.model.dto.BillDto;
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
    public ResponseEntity<BillDto> addBill(@RequestBody final BillDto billDto, @RequestParam String email) {
        Bill bill = billService.addBill(Bill.from(billDto), email);
        return new ResponseEntity<>(BillDto.from(bill), HttpStatus.OK);
    }
}
