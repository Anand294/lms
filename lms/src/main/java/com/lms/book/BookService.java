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

    public Optional<BookMaster> getBookById(int bookId) {
        return bookRepository.findById(bookId);
    }

    public Iterable<BookMaster> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
    public void inactivateBook(int bookId) {
        Optional<BookMaster> bookOpt = bookRepository.findById(bookId);
        if (bookOpt.isPresent()) {
            BookMaster book = bookOpt.get();
            book.setStatus("inactive");  // Set the status to "inactive"
            bookRepository.save(book);   // Save the updated book entity
        }
    }
}