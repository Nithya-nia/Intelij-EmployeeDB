package org.example.employeedb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(IllegalArgumentException e) {

        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}