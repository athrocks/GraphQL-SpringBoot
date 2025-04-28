package com.graphql.learn.controller;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return this.bookService.create(book);
    }

    @GetMapping
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable int bookId){
        return this.bookService.get(bookId);
    }

}
