package com.assignment.cashrichassignment.Controllers;

import com.assignment.cashrichassignment.DTOs.RequestCoinMarketDto;
import com.assignment.cashrichassignment.Services.CryptoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coinmarket")
public class CoinMarketController {

    private final CryptoService cryptoService;

    public CoinMarketController(CryptoService cryptoService){
        this.cryptoService = cryptoService;
    }

    @PostMapping("/")
    public void getAndStoreCoinMarketData(@RequestBody RequestCoinMarketDto requestCoinMarketDto){
        cryptoService.getAndStoreCoinMarketData(requestCoinMarketDto.getUsername(), requestCoinMarketDto.getSymbols());
    }
}
