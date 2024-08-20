package com.lms.transactions;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<TransactionsMaster, Integer>{

	 @Query("SELECT t FROM TransactionsMaster t WHERE t.userId = ?1")
	    Iterable<TransactionsMaster> findByUserId(String userId);
	 
	 @Query("SELECT t FROM TransactionsMaster t WHERE t.bookId = ?1")
	    Iterable<TransactionsMaster> findByBookId(String BookId);
	
}
