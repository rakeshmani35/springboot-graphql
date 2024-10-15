package com.spring.boot.graphql.pringbootgraphqlcustomescalar.config;

import com.tailrocks.graphql.datetime.GraphqlDateCoercing;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class DateScaler {

    @Bean
    public static GraphQLScalarType create(String name) {
        return GraphQLScalarType.newScalar()
                .name(name != null ? name : "Date")
                .description("A Java Date type")
                .coercing(new GraphqlDateCoercing())
                .build();
    }
}
