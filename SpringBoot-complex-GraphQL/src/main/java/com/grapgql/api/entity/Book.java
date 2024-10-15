package com.grapgql.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
//import org.springframework.data.redis.core.RedisHash;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@RedisHash("Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String desc;
    private double price;
    //    @OneToOne(cascade = CascadeType.ALL)
//    private Author author;
//    @OneToOne(cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors;
    private int pages;

}
