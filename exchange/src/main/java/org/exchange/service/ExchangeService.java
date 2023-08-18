package org.exchange.service;

import org.exchange.dto.ConvertResponse;
import org.exchange.dto.RateResponse;

import java.math.BigDecimal;

public interface ExchangeService {
    RateResponse exchangeRate(String fromCurrency, String toCurrency);

    ConvertResponse convertCurrency(String fromCurrency, String toCurrency, BigDecimal amount);
}
