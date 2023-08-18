package org.exchange.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.exchange.dto.ConvertResponse;
import org.exchange.dto.RateResponse;
import org.exchange.service.ExchangeService;
import org.exchange.service.impl.ExchangeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/exchange-rates")
    public ResponseEntity<RateResponse> getAllCasinoBonusTemplate(@RequestParam(value = "fromCurrency") String fromCurrency,
                                                                  @RequestParam(value = "toCurrency") String toCurrency) {
        return ResponseEntity.ok(
                exchangeService.exchangeRate(fromCurrency, toCurrency)
        );
    }

    @GetMapping("/convert")
    public ResponseEntity<ConvertResponse> convertCurrency(@RequestParam(value = "fromCurrency") String fromCurrency,
                                                           @RequestParam(value = "toCurrency") String toCurrency,
                                                           @RequestParam(value = "amount") BigDecimal amount) {
        return ResponseEntity.ok(exchangeService.convertCurrency(fromCurrency, toCurrency, amount));
    }

}
