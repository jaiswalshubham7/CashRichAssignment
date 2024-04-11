package com.assignment.cashrichassignment.Exceptions;

public class CoinMarketDataNotFoundException extends RuntimeException{
    public CoinMarketDataNotFoundException(String message){
        super(message);
    }
}
