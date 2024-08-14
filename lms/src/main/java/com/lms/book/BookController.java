package com.lms.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
    }
}
