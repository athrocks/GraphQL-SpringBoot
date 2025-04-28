package com.graphql.learn.repositories;

import com.graphql.learn.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findAllById(int bookId);
}
