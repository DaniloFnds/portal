package br.com.dhan.handlers;

import br.com.dhan.handlers.exceptions.GenericBadRequestException;
import br.com.dhan.handlers.exceptions.GenericExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GenericExceptionResponse.class)
    public ResponseEntity<GenericExceptionResponse> handlerGenericExpcetion(Exception e, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericExceptionResponse(new Date(), e.getMessage(), request.getDescription(false)));
    }


    @ExceptionHandler(GenericBadRequestException.class)
    public ResponseEntity<GenericExceptionResponse> handlerGenericBadRequestExpcetion(Exception e, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new GenericExceptionResponse(new Date(), e.getMessage(), request.getDescription(false)));
    }
}
