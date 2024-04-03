package com.grapgql.api.repository;

import com.grapgql.api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBooksByIdAndAuthor(Integer id, String author);

}
