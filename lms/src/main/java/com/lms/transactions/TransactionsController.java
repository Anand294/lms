package com.lms.transactions;

import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public TransactionsMaster addUpdateTransaction(@ModelAttribute TransactionsMaster transaction) {
		return transactionService.addUpdate(transaction);
	}
	@GetMapping("/{id}")
	public Optional<TransactionsMaster> getTransactionById(@PathVariable("id") int id){
		return transactionService.getTransactionById(id);
	}
	@GetMapping("/all")
	public Iterable<TransactionsMaster> getAllTransactions(){
		return transactionService.getAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteTransaction(@PathVariable("id") int id) {
		transactionService.inactivateTransaction(id);
	}

	
}
