package com.grapgql.api.repository;

import com.grapgql.api.entity.Author;
import com.grapgql.api.entity.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
//@EnableRedisRepositories
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByTitle(String title);

    Book findBooksByTitleAndPages(String title, int page);

}
