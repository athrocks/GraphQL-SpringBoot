package com.graphql.learn.controller;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @MutationMapping("createBook")
    public Book create(@Argument("book") BookInput bookInput) {
        Book book = new Book();
        book.setTitle(bookInput.getTitle());
        book.setAuthor(bookInput.getAuthor());
        book.setPrice(bookInput.getPrice());
        book.setDesc(bookInput.getDesc());
        book.setPages(bookInput.getPages());

        return this.bookService.create(book);
    }

    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @QueryMapping("getBook")
    public Book get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }

}


class BookInput {
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;

    public BookInput() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
