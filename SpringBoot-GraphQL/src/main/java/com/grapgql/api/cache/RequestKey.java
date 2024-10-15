package com.grapgql.api.cache;

import java.util.List;
import lombok.Value;

@Value
public class RequestKey {

    String userId;
    List<String> queries;

}
