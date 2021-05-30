package com.dima.financeapp.model.exception;

import java.text.MessageFormat;

public class BillIsAlreadyAssignedException extends RuntimeException {

    public BillIsAlreadyAssignedException(final Long billId, final Long userId) {
        super(MessageFormat.format("Bill: {0} is already assigned to user: {1}", billId, userId));
    }
}
