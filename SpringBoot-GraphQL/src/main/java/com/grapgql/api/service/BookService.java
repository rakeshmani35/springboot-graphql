package com.grapgql.api.service;

import com.grapgql.api.entity.Book;

import java.util.List;

public interface BookService {

    public Book create(Book book);

    public List<Book> getAll();

    public Book getBook(int id);
    public Book getBookByIdAndAutor(int id, String author);
}
