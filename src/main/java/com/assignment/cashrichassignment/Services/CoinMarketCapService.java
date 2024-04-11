package com.assignment.cashrichassignment.Services;

import com.assignment.cashrichassignment.DTOs.CoinMarketDtos.CoinMarketCapResponseDto;
import com.assignment.cashrichassignment.Exceptions.CoinMarketDataNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.logging.Logger;

@Service
public class CoinMarketCapService implements CryptoService{

    private final RestTemplate restTemplate;
    private final String apiKey = "27ab17d1-215f-49e5-9ca4-afd48810c149";

    public CoinMarketCapService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public void getAndStoreCoinMarketData(String username, String symbols) {

        ResponseEntity<CoinMarketCapResponseDto> coinMarketCapResponseDtoResponseEntity = restTemplate
                .getForEntity(
                        "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol="+symbols
                        +"&CMC_PRO_API_KEY="+apiKey,
                        CoinMarketCapResponseDto.class
                );

        if (coinMarketCapResponseDtoResponseEntity.getStatusCode() != HttpStatusCode.valueOf(200)){
            Logger.getLogger("Fetching products from FakeStore throws the exception.");
            Logger.getLogger("Exception Code : " + coinMarketCapResponseDtoResponseEntity.getStatusCode());
            throw new CoinMarketDataNotFoundException("Coin Market Data Not Found or Exception Occurred.");
        }

        System.out.println("Data" + Objects.requireNonNull(coinMarketCapResponseDtoResponseEntity));
        Logger.getLogger("Coin Market Data Fetched Successfully.");

    }
}
