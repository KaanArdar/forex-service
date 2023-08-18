package org.exchange.mapper;

import org.exchange.client.response.ConvertCurrencyResponse;
import org.exchange.dao.entity.ExchangeTransaction;

public class ExchangeTransactionEntityMapper {

    private static String RATE = "rate";

    public static ExchangeTransaction toEntity(String toCurrency,ConvertCurrencyResponse convertCurrencyResponse){
        return ExchangeTransaction.builder()
                .amount(convertCurrencyResponse.getAmount())
                .transactionDate(System.currentTimeMillis())
                .toCurrency(toCurrency)
                .fromCurrency(convertCurrencyResponse.getBase())
                .rate(convertCurrencyResponse.getResult().get(RATE))
                .convertedAmount(convertCurrencyResponse.getResult().get(toCurrency))
                .build();
    }

}
