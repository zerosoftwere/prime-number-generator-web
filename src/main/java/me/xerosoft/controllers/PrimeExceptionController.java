package me.xerosoft.controllers;

import me.xerosoft.domain.prime.exceptions.PrimeStrategyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PrimeExceptionController {

    @ExceptionHandler(value = PrimeStrategyException.class)
    public ResponseEntity<Object> exception(PrimeStrategyException exception) {
        String response = String.format("%s use [sv, td, cd]", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
