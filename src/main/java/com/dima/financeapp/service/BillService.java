package com.dima.financeapp.service;

import com.dima.financeapp.model.Bill;
import com.dima.financeapp.model.User;
import com.dima.financeapp.model.exception.BillIsAlreadyAssignedException;
import com.dima.financeapp.model.exception.BillNotFoundException;
import com.dima.financeapp.repository.BillRepository;
import com.dima.financeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class BillService {

    private final UserRepository userRepository;
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.billRepository = billRepository;
    }

    @Transactional
    public Bill addBill(Bill newBill, String email) {
        Bill bill = billRepository.save(newBill);
        User user = userRepository.getUserByEmail(email);
        if (Objects.nonNull(bill.getUser())) {
            throw new BillIsAlreadyAssignedException(bill.getId(), bill.getUser().getId());
        }
        user.addBill(bill);
        return bill;
    }

    @Transactional
    public Bill deleteBill(Long id) {
        Bill bill = getBill(id);
        billRepository.delete(bill);
        return bill;
    }

    @Transactional
    public Bill editBill(Long id, Bill bill) {
        Bill billToEdit = getBill(id);
        billToEdit.setName(bill.getName());
        billToEdit.setAmount(bill.getAmount());
        billToEdit.setColor(bill.getColor());
        return billToEdit;
    }

    public Bill getBill(Long id) {
        return billRepository.findById(id).orElseThrow(() ->
                new BillNotFoundException(id));
    }
}
