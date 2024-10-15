package com.grapgql.api.service.impl;

import com.grapgql.api.entity.Book;
import com.grapgql.api.repository.BookRepository;
import com.grapgql.api.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;


    public BookServiceImpl(BookRepository repository) {
        this.bookRepository = repository;
    }


    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book is not found"));
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        List<Book> booksByTitle = bookRepository.findBooksByTitle(title);
        return booksByTitle;
    }

    @Override
    public Book findBooksByTitleAndPages(String title, int page) {
        Book booksByTitleAndPages = bookRepository.findBooksByTitleAndPages(title, page);
        return booksByTitleAndPages;
    }

    @Override
    public Book getBookByIdAndAutorName(int id, String author) {
        List<Book> list = new ArrayList();
        Book b = new Book();
        b.setId(id);
        b.setAuthor(author);
        list.add(b);
        list.add(b);

        return bookRepository.findBooksByIdAndAuthor_Name(id, author);
    }
}
