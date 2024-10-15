package com.grapgql.api.helper;

import com.grapgql.api.entity.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInputDto {
    private String title;
    private String desc;
    private Author author;
    private double price;
    private int pages;
}