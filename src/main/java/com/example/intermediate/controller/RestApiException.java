package com.example.intermediate.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestApiException {
    private String Field;
    private String errorMessage;

}
