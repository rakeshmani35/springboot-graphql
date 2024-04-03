package com.graphql.api.repository;

import com.graphql.api.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findByEmail(String email);

}
