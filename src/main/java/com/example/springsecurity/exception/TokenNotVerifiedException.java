package com.example.springsecurity.exception;

public class TokenNotVerifiedException extends RuntimeException {

    public TokenNotVerifiedException(String message) {
        super(message);
    }

}
