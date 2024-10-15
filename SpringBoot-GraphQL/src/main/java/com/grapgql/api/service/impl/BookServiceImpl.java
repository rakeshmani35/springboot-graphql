package com.grapgql.api.service.impl;

import com.grapgql.api.entity.Book;
import com.grapgql.api.repository.BookRepository;
import com.grapgql.api.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

//    public static final String HASH_KEY = "Product";

//    private RedisTemplate redisTemplate;

    public BookServiceImpl(BookRepository repository) {
        this.bookRepository = repository;
    }

//    public BookServiceImpl(BookRepository repository, RedisTemplate template) {
//        this.bookRepository = repository;
//        this.redisTemplate = template;
//    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
//        List ans = redisTemplate.opsForHash().values(HASH_KEY);
        return bookRepository.findAll();
//        return ans;
    }

    @Override
    public Book getBook(int id) {
//        Book book = (Book) redisTemplate.opsForHash().get(HASH_KEY, id);
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book is not found"));
//        return book;
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

//    @Override
//    public Book getBookByIdAndAutorName(int id, String author) {
//        List<Book> list = new ArrayList();
//        Book b = new Book();
//        b.setId(id);
//        b.setAuthor(author);
//        list.add(b);
//        list.add(b);
//
//        Book book = (Book) redisTemplate.opsForHash().get(HASH_KEY, list);
//        List ans = redisTemplate.opsForHash().multiGet(HASH_KEY, list);
//        return bookRepository.findBooksByIdAndAuthor_Name(id, author);
//    }
}
