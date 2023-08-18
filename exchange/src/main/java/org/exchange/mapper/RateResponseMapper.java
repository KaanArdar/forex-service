package org.exchange.mapper;

import org.exchange.client.response.ExchangeRateResponse;
import org.exchange.dto.RateResponse;

public class RateResponseMapper {

    public static RateResponse toMap(String toCurrency, ExchangeRateResponse exchangeRateResponse){
        return RateResponse.builder()
                .toCurrency(toCurrency)
                .fromCurrency(exchangeRateResponse.getBase())
                .rate(exchangeRateResponse.getResult().get(toCurrency))
                .build();
    }

}
