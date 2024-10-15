package com.graphql.country.displaycountry.controller;

import com.graphql.country.displaycountry.entity.Country;
import com.graphql.country.displaycountry.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    public CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService=countryService;
    }

    @PostMapping
    public void getCountries(){
        Mono<List<Country>> countries = countryService.getCountries();
//        List<Country> countryList = countries.blockOptional().get();
//        return countries;
    }
}
