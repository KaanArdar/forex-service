package org.exchange.client;

import lombok.RequiredArgsConstructor;
import org.exchange.client.api.FastForexApi;
import org.exchange.client.response.ConvertCurrencyResponse;
import org.exchange.client.response.ExchangeRateResponse;
import org.exchange.client.config.FastForexConfig;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ForexClient {

    private final FastForexApi fastForexApi;
    private final FastForexConfig fastForexConfig;

    public ExchangeRateResponse exchangeRate(String fromCurrency, String toCurrency) {
        return fastForexApi.exchangeRate(fastForexConfig.getFastForexApiKey(), fromCurrency, toCurrency);
    }

    public ConvertCurrencyResponse convertCurrency(String fromCurrency, String toCurrency, BigDecimal amount) {
        return fastForexApi.convertCurrency(fastForexConfig.getFastForexApiKey(), fromCurrency, toCurrency, amount);
    }


}
