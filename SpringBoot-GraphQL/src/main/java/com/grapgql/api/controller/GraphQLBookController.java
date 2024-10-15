package com.grapgql.api.controller;

import com.grapgql.api.entity.Author;
import com.grapgql.api.entity.Book;
import com.grapgql.api.helper.BookInputDto;
import com.grapgql.api.service.BookService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
//@EnableRedisRepositories(basePackages = "com.grapgql.api.config")
//@EnableJpaRepositories(basePackages = "com.grapgql.api.repository")
public class GraphQLBookController {

    HttpGraphQlClient httpGraphQlClient;

    private BookService bookService;

    public GraphQLBookController(BookService bookService) {
        this.bookService = bookService;
    }


    //   @PostMapping
    @MutationMapping("createBook")
    public Book create(@Argument BookInputDto book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        List<Author> authors = new ArrayList<>();
        authors.add(book.getAuthor());
        b.setAuthors(authors);
        b.setPages(book.getPages());
        return bookService.create(b);
    }

    //  @GetMapping
    //    @SchemaMapping
    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    // @GetMapping
    @QueryMapping("getBookById")
    @Cacheable(key = "#bookId", value = "book")
    public Book getBookById(@Argument int bookId) {
        return bookService.getBook(bookId);
    }

    @QueryMapping("getBook")
    @Cacheable(key = "#book", value = "book")
    public List<Book> getBook(@Argument BookInputDto book) {
        return bookService.getBookByTitle(book.getTitle());
    }

//    @QueryMapping("getBook")
//    @Cacheable(key = "#book", value = "book")
//    public Book findBooksByTitleAndPages(@Argument BookInputDto book) {
//        return bookService.findBooksByTitleAndPages(book.getTitle(), book.getPages());
//    }


//    @QueryMapping("getBookByIdAndAuthor")
//    @Cacheable(key = "{#bookId, #author}", value = "book")
//    public Book getBookByIdAndAutor(@Argument int bookId, @Argument String author) {
//        return bookService.getBookByIdAndAutorName(bookId, author);
//    }

}

