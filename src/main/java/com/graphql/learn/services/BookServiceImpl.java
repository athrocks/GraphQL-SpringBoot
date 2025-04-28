package com.graphql.learn.services;

import com.graphql.learn.entities.Book;
import com.graphql.learn.repositories.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book create(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book get(int bookId) {
        return this.bookRepo.findAllById(bookId);
    }
}
