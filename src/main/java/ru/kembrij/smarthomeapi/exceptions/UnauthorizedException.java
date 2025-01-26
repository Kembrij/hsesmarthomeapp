package ru.kembrij.smarthomeapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.*;


public class UnauthorizedException extends ApiException {

    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(HttpStatus.UNAUTHORIZED, message, cause);
    }

}

