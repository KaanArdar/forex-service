package org.exchange.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.exchange.client.response.ConvertCurrencyResponse;
import org.exchange.client.response.ExchangeRateResponse;

import java.math.BigDecimal;

public interface FastForexApi {

    @RequestLine("GET /fetch-one?from={fromCurrency}&to={toCurrency}&api_key={apiKey}")
    @Headers({"Content-Type: application/json"})
    ExchangeRateResponse exchangeRate(@Param("apiKey") String apiKey,
                                      @Param("fromCurrency") String fromCurrency,
                                      @Param("toCurrency") String toCurrency);

    @RequestLine("GET /convert?from={fromCurrency}&to={toCurrency}&amount={amount}&api_key={apiKey}")
    @Headers({"Content-Type: application/json"})
    ConvertCurrencyResponse convertCurrency(@Param("apiKey") String apiKey,
                                            @Param("fromCurrency") String fromCurrency,
                                            @Param("toCurrency") String toCurrency,
                                            @Param("amount") BigDecimal amount);

}
