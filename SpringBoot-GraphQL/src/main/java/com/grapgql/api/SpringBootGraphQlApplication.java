package com.grapgql.api;

import com.grapgql.api.entity.Book;
import com.grapgql.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootGraphQlApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphQlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book();
        b1.setTitle("Complete reference");
        b1.setDesc("java book");
        b1.setPrice(100.00);
        b1.setAuthor("Rakesh");
        b1.setPages(500);

        Book b2 = new Book();
        b2.setTitle("Think Java");
        b2.setDesc("java for learning");
        b2.setPrice(300.00);
        b2.setAuthor("Roshan");
        b2.setPages(1100);

		Book b3 = new Book();
		b3.setTitle("Head first to java");
		b3.setDesc("java stating");
		b3.setPrice(700.00);
		b3.setAuthor("Mike");
		b3.setPages(900);

        bookService.create(b1);
        bookService.create(b2);
		bookService.create(b3);
    }
}
