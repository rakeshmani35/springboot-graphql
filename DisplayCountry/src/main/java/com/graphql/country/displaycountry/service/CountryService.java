package com.graphql.country.displaycountry.service;

import com.graphql.country.displaycountry.entity.Country;
import com.graphql.country.displaycountry.repository.CountryRepository;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryService {

    private HttpGraphQlClient graphQlClient;
    private HttpGraphQlClient httpGraphQlClient;
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        WebClient webClient = WebClient.builder().baseUrl("https://countries.trevorblades.com").build();
        graphQlClient = HttpGraphQlClient.builder(webClient).build();
//        HttpGraphQlClient httpGraphQlClient = HttpGraphQlClient.create(webClient);
        this.countryRepository = countryRepository;
    }

    public Mono<List<Country>> getCountries() {
        String document = """
                Query {
                countries {
                              name
                              emoji
                              currency
                              code
                              capital
                            }
                }
                """;

        Mono<List<Country>> countries = graphQlClient.document(document)
                                                     .retrieve("countries")
                                                     .toEntityList(Country.class);

        Disposable subscribe = countries.subscribe(countryRepository::saveAll);


        return countries;
    }

}
