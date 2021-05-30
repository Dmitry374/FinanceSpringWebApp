package com.dima.financeapp.model.exception;

import java.text.MessageFormat;

public class BillNotFoundException extends RuntimeException {

    public BillNotFoundException(final Long id) {
        super(MessageFormat.format("Could not find bill with id: {0}", id));
    }
}
