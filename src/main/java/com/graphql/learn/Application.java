package com.graphql.learn;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setTitle("Lets Go");
		b1.setDesc("Learning Go");
		b1.setPages(234);
		b1.setPrice(2000);
		b1.setAuthor("Edwards");

		Book b2 = new Book();
		b2.setTitle("Lets Go Further");
		b2.setDesc("Learning Go Advanced");
		b2.setPages(349);
		b2.setPrice(3000);
		b2.setAuthor("Edwards");

		Book b3 = new Book();
		b3.setTitle("Grokking System Design");
		b3.setDesc("Learning System Design");
		b3.setPages(89);
		b3.setPrice(245);
		b3.setAuthor("Alex Wu");

		this.bookService.create(b1);
		this.bookService.create(b2);
		this.bookService.create(b3);
	}
}
