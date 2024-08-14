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
    public BookMaster createBook(@RequestBody BookMaster book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public Optional<BookMaster> getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/all")
    public Iterable<BookMaster> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
    }
}
