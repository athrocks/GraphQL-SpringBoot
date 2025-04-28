package com.graphql.learn.services;

import com.graphql.learn.entities.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    List<Book> getAll();

    Book get(int bookId);
}
