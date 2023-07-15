package com.example.springprojects.project1.controllers;

import com.example.springprojects.project1.core.validation.CoreError;
import com.example.springprojects.project1.core.validation.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleControllerViolationException(ConstraintViolationException e) {
        List<CoreError> errors = e.getConstraintViolations().stream()
                .map(exception -> exception.getPropertyPath() + ": " + exception.getMessage())
                .map(message -> new CoreError(message))
                .toList();

        ErrorResponse response = new ErrorResponse();
        response.setErrorList(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
