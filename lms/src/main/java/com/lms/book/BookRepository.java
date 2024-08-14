package com.lms.book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookMaster, Integer> {
	
}
