package com.grapgql.api.config;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

//import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@Component
public class DateScalar /*extends GraphQLScalarType*/ {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//    public DateScalar() {
//
//        super("Date", "Date custom scalar", new Coercing<LocalDate, String>() {
//            @Override
//            public String serialize(Object dataFetcherResult) {
//                if (dataFetcherResult instanceof LocalDate) {
//                    return ((LocalDate) dataFetcherResult).format(DATE_FORMAT);
//                }
//                throw new IllegalArgumentException("Invalid date");
//            }
//
//            @Override
//            public LocalDate parseValue(Object input) {
//                return LocalDate.parse(input.toString(), DATE_FORMAT);
//            }
//
//            @Override
//            public LocalDate parseLiteral(Object input) {
//                if (input instanceof StringValue) {
//                    return LocalDate.parse(((StringValue) input).getValue(), DATE_FORMAT);
//                }
//                throw new IllegalArgumentException("Invalid date");
//            }
//        });
//    }
}
