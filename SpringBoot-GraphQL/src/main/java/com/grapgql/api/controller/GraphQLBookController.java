package com.grapgql.api.controller;

import com.grapgql.api.entity.Book;
import com.grapgql.api.helper.BookInput;
import com.grapgql.api.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class GraphQLBookController {

    HttpGraphQlClient httpGraphQlClient;

    private BookService bookService;

    public GraphQLBookController(BookService bookService) {
        this.bookService = bookService;
    }


    //   @PostMapping
    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
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
    @QueryMapping("getBook")
    public Book getBook(@Argument int bookId) {
        return bookService.getBook(bookId);
    }

    @QueryMapping("getBookByIdAndAuthor")
    public Book getBookByIdAndAutor(@Argument int bookId, @Argument String author) {
        return bookService.getBookByIdAndAutor(bookId,author);
    }

}

