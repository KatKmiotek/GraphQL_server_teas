package com.learning.GraphQL.web;

import java.net.URISyntaxException;

public class ApiException extends URISyntaxException {

    private static final long serialVersionUID = 1L;

    public ApiException(String input, String reason){
        super(input, reason);
    }
}
