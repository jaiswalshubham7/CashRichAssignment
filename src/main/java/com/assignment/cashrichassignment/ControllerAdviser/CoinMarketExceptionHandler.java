package com.assignment.cashrichassignment.ControllerAdviser;

import com.assignment.cashrichassignment.DTOs.AppRuntimeException;
import com.assignment.cashrichassignment.Exceptions.CoinMarketDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class CoinMarketExceptionHandler {

    @ExceptionHandler(CoinMarketDataNotFoundException.class)
    public ResponseEntity<AppRuntimeException> handleCoinMarketDataNotFoundException(CoinMarketDataNotFoundException coinMarketDataNotFoundException){
        AppRuntimeException appRuntimeException = AppRuntimeException.builder()
                .message(coinMarketDataNotFoundException.getMessage())
                .timestamp(String.valueOf(Instant.now()))
                .build();

        return new ResponseEntity<>(
                appRuntimeException, HttpStatus.NOT_FOUND
        );
    }
}
