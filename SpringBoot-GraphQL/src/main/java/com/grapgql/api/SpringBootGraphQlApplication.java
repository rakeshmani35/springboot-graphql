package com.grapgql.api;

import com.grapgql.api.entity.Author;
import com.grapgql.api.entity.Book;
import com.grapgql.api.entity.Product;
import com.grapgql.api.service.BookService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootGraphQlApplication /*implements CommandLineRunner*/ {

    @Autowired
    private BookService bookService;

    @PostConstruct
    public void addData() {
        Book b1 = new Book();

        b1.setTitle("Complete reference");
        b1.setDesc("java book");
        b1.setPrice(100.00);
        List<Author> authors1 = new ArrayList<>();
        Author author1 = new Author();
        author1.setName("Rakesh");
        Product p1 = new Product();
        p1.setTitle("product1");
        author1.setProduct(p1);
        authors1.add(author1);
        b1.setAuthors(authors1);
        b1.setPages(500);

        Book b2 = new Book();
        b2.setTitle("Think Java");
        b2.setDesc("java for learning");
        b2.setPrice(300.00);
        List<Author> authors2 = new ArrayList<>();
        Author author2 = new Author();
        author2.setName("Roshan");
        Product p2 = new Product();
        p2.setTitle("product2");
        author2.setProduct(p2);
        authors2.add(author2);
        b2.setAuthors(authors2);
        b2.setPages(1100);

        Book b3 = new Book();
        b3.setTitle("Head first to java");
        b3.setDesc("java stating");
        b3.setPrice(700.00);
        List<Author> authors3 = new ArrayList<>();
        Author author3 = new Author();
        author3.setName("Mike");
        Product p3 = new Product();
        p3.setTitle("product3");
        author3.setProduct(p3);
        authors3.add(author3);
        b3.setAuthors(authors3);
        b3.setPages(900);

        bookService.create(b1);
        bookService.create(b2);
        bookService.create(b3);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphQlApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Book b1 = new Book();
//        b1.setTitle("Complete reference");
//        b1.setDesc("java book");
//        b1.setPrice(100.00);
//        b1.setAuthor("Rakesh");
//        b1.setPages(500);
//
//        Book b2 = new Book();
//        b2.setTitle("Think Java");
//        b2.setDesc("java for learning");
//        b2.setPrice(300.00);
//        b2.setAuthor("Roshan");
//        b2.setPages(1100);
//
//		Book b3 = new Book();
//		b3.setTitle("Head first to java");
//		b3.setDesc("java stating");
//		b3.setPrice(700.00);
//		b3.setAuthor("Mike");
//		b3.setPages(900);
//
//        bookService.create(b1);
//        bookService.create(b2);
//		bookService.create(b3);
//    }
}
