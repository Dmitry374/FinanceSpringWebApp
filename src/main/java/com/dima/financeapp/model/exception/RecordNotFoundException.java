package com.dima.financeapp.model.exception;

import java.text.MessageFormat;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(final Long id) {
        super(MessageFormat.format("Could not find record with id: {0}", id));
    }
}
