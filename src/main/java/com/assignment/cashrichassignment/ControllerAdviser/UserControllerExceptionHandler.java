package com.assignment.cashrichassignment.ControllerAdviser;

import com.assignment.cashrichassignment.DTOs.AppRuntimeException;
import com.assignment.cashrichassignment.Exceptions.InvalidPasswordException;
import com.assignment.cashrichassignment.Exceptions.UserAlreadyExistException;
import com.assignment.cashrichassignment.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserControllerExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<AppRuntimeException> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        AppRuntimeException appRuntimeException = AppRuntimeException.builder()
                .message(userNotFoundException.getMessage())
                .timestamp(String.valueOf(Instant.now()))
                .build();

        return new ResponseEntity<>(
                appRuntimeException, HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = {InvalidPasswordException.class})
    public ResponseEntity<AppRuntimeException> handleInvalidPasswordException(InvalidPasswordException invalidPasswordException) {
        AppRuntimeException appRuntimeException = AppRuntimeException.builder()
                .message(invalidPasswordException.getMessage())
                .timestamp(String.valueOf(Instant.now()))
                .build();

        return new ResponseEntity<>(
                appRuntimeException, HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = {UserAlreadyExistException.class})
    public ResponseEntity<AppRuntimeException> handleInvalidPasswordException(UserAlreadyExistException userAlreadyExistException) {
        AppRuntimeException appRuntimeException = AppRuntimeException.builder()
                .message(userAlreadyExistException.getMessage())
                .timestamp(String.valueOf(Instant.now()))
                .build();

        return new ResponseEntity<>(
                appRuntimeException, HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppRuntimeException> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(
                AppRuntimeException.builder()
                        .message(errors.toString())
                        .timestamp(String.valueOf(Instant.now()))
                        .build(), HttpStatus.BAD_REQUEST
        );
    }
}
