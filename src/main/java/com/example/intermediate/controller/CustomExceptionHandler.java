package com.example.intermediate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleApiRequestException(MethodArgumentNotValidException ex) {
        String field = ex.getBindingResult().getFieldError().getField();
        String errorMessage = ex.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        RestApiException restApiException = new RestApiException();

        restApiException.setField(field);
        restApiException.setErrorMessage(errorMessage);

        return new ResponseEntity(
                restApiException,
                HttpStatus.BAD_REQUEST
        );
    }
}
