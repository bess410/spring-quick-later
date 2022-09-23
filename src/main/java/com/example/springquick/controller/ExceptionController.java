package com.example.springquick.controller;

import com.example.springquick.dto.ErrorDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ConnectException.class)
    public ErrorDetails getErrorDetails(Exception e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Отсутствует подключение");
        return errorDetails;
    }
}
