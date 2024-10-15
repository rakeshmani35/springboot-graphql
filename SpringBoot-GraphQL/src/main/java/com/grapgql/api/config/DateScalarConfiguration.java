package com.grapgql.api.config;



//@Configuration
public class DateScalarConfiguration {

//    @Bean
//    public GraphQLScalarType dateScalar() {
//
//        GraphQLScalarType graphQLScalarType = GraphQLScalarType.newScalar().name("Date")
//                .coercing(new Coercing<LocalDate, String>() {
//
//                    @Override
//                    public String serialize(final Object dataFetcherResult) {
//                        if (dataFetcherResult instanceof LocalDate) {
//                            return dataFetcherResult.toString();
//                        } else {
//                            throw new CoercingSerializeException("Expected a LocalDate object.");
//                        }
//                    }
//
//                    @Override
//                    public LocalDate parseValue(final Object input) {
//                        try {
//                            if (input instanceof String) {
//                                return LocalDate.parse((String) input);
//                            } else {
//                                throw new CoercingParseValueException("Expected a String");
//                            }
//                        } catch (DateTimeParseException e) {
//                            throw new CoercingParseValueException(String.format("Not a valid date: '%s'.", input), e
//                            );
//                        }
//                    }
//
//                    @Override
//                    public LocalDate parseLiteral(final Object input) {
//                        if (input instanceof StringValue) {
//                            try {
//                                return LocalDate.parse(((StringValue) input).getValue());
//                            } catch (DateTimeParseException e) {
//                                throw new CoercingParseLiteralException(e);
//                            }
//                        } else {
//                            throw new CoercingParseLiteralException("Expected a StringValue.");
//                        }
//                    }
//
//                }).build();
//
//        return graphQLScalarType;
//    }

}
