package org.troche.spring.application.exercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientResponseException;

/** Exception to throw when the URL query parameters are invalid. */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidQueryParameter extends RestClientResponseException {
    public InvalidQueryParameter(final String message) {
        super(message, 400, "Bad Request", null, null, null);
    }
}
