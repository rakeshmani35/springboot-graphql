package com.graphql.country.displaycountry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {

    @Id
    Integer id;
    String name;
    String emoji;
    String currency;
    String code;
    String capital;
}
