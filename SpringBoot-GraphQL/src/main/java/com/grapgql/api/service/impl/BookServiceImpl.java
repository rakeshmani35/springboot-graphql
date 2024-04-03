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
    public Book getBookByIdAndAutor(int id,String author) {
        return bookRepository.findBooksByIdAndAuthor(id,author);
    }
}
