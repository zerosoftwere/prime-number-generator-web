package me.xerosoft.controllers;

import me.xerosoft.domain.prime.exceptions.PrimeStrategyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PrimeExceptionController {

    @ExceptionHandler(value = PrimeStrategyException.class)
    public ResponseEntity<String> strategyException(PrimeStrategyException exception) {
        String response = String.format("%s use [sv, td, cd]", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<String> rangeException(IndexOutOfBoundsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<String> parameterException(MissingServletRequestParameterException ex) {
        return new ResponseEntity<>("specify start and end query parameter", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<String> numberFormatException(NumberFormatException ex) {
        return new ResponseEntity<>("invalid input number", HttpStatus.BAD_REQUEST);
    }
}
