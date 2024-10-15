package com.spring.boot.graphql.pringbootgraphqlcustomescalar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Boolean isOnSale;
    private Float weight;
    private BigDecimal price;
    private LocalDateTime dateCreated;

    public Product(String title) {
        this.title = title;
    }

    public Product(String title, Boolean isOnSale, Float weight) {
        this.title = title;
        this.isOnSale = isOnSale;
        this.weight = weight;
    }

    public Product(String title, Boolean isOnSale, Float weight, BigDecimal price, LocalDateTime dateCreated) {
        this.title = title;
        this.isOnSale = isOnSale;
        this.weight = weight;
        this.price = price;
        this.dateCreated = dateCreated;
    }
}
