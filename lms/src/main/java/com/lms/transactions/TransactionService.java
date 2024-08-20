package com.lms.transactions;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lms.book.BookService;

@Service
public class TransactionService {

	@Autowired
	private TransactionsRepository transactionsRepository;
	@Autowired
    private BookService bookService;
    
	public TransactionsMaster addUpdate(TransactionsMaster transactions){
		 bookService.updateBookQuantity(transactions.getBookId(), transactions.getQuantity(), transactions.getTransType());
		return transactionsRepository.save(transactions);
	}
	public Optional<TransactionsMaster> getTransactionById(int id){
		return transactionsRepository.findById(id);
	}
    public Iterable<TransactionsMaster> getAll(){
    	return transactionsRepository.findAll();
    }
    public void inactivateTransaction(int id) {
    	Optional<TransactionsMaster> transMasterOpt=transactionsRepository.findById(id);
    	if(transMasterOpt.isPresent()) {
    		TransactionsMaster transaction=transMasterOpt.get();
    		transaction.setStatus("Inactive");
    		transactionsRepository.save(transaction);
    	}
    }
    public Iterable<TransactionsMaster> getTransactionsByUser(String UserId){
    	return transactionsRepository.findByUserId(UserId);
    }
    public Iterable<TransactionsMaster> getTransactionsByBook(String BookId){
    	return transactionsRepository.findByBookId(BookId);
    }
    
	}