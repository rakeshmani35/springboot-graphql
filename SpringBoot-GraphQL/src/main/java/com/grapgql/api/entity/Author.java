package com.grapgql.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    private LocalDateTime dob;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
//    @OneToOne
//    private Book book;
}
