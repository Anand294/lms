package com.lms.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookMaster createBook(BookMaster book) {
        return bookRepository.save(book);
    }

    public Optional<BookMaster> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Iterable<BookMaster> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
}