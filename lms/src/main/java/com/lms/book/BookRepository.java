package com.lms.book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lms.transactions.TransactionsMaster;

public interface BookRepository extends CrudRepository<BookMaster, Integer> {
}
