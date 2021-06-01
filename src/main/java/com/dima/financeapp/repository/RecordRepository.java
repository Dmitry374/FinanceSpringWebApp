package com.dima.financeapp.repository;

import com.dima.financeapp.model.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long> {
}
