package br.com.dhan.handlers.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@RequiredArgsConstructor
public class GenericExceptionResponse extends Exception {

    private final Date data;
    private final String message;
    private final String details;
}
