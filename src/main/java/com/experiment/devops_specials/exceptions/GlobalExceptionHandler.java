package com.experiment.devops_specials.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectAlreadyExists.class)
    public ResponseEntity<BaseExceptionResponse> handleObjectAlreadyExists(ObjectAlreadyExists exception) {
        BaseExceptionResponse response = BaseExceptionResponse.builder()
                .errorMessage(exception.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST)
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
