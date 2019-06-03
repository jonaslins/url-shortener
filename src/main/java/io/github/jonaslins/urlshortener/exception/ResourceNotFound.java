package io.github.jonaslins.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

    private static final String defaultMessage = "Resource not found";

    public ResourceNotFound() {
        super(defaultMessage);
    }
}
