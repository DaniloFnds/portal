package br.com.dhan.handlers.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenericBadRequestException extends RuntimeException {

    public GenericBadRequestException(String message) {
        super(message);
    }
}
