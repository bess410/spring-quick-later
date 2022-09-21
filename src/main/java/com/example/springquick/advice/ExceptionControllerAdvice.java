package com.example.springquick.advice;

import com.example.springquick.dto.ErrorDetails;
import com.example.springquick.exception.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(NotEnoughMoneyException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
