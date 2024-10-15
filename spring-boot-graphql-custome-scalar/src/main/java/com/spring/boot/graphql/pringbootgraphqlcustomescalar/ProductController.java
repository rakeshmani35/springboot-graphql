package com.spring.boot.graphql.pringbootgraphqlcustomescalar;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }


    @QueryMapping("allProducts")
    public List<Product> findAll() {
        return repository.findAll();
    }
}
