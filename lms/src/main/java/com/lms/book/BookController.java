package com.lms.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookMaster createBook(@ModelAttribute BookMaster book) {
		
        return bookService.createBook(book);
    }

    @GetMapping("/{bookId}")
    public Optional<BookMaster> getBookById(@PathVariable("bookId") int bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/all")
    public Iterable<BookMaster> getAllBooks() {
    	System.out.println(bookService.getBookById(1).toString());
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") int id) {
        bookService.inactivateBook(id);
    }
}
