package org.exchange.mapper;

import org.exchange.dao.entity.ExchangeTransaction;
import org.exchange.dto.ConvertResponse;

public class ConvertResponseMapper {

    private static String RATE = "rate";

    public static ConvertResponse toMap(ExchangeTransaction exchangeTransaction) {
        return ConvertResponse.builder()
                .transactionId(exchangeTransaction.getId())
                .toCurrency(exchangeTransaction.getToCurrency())
                .fromCurrency(exchangeTransaction.getFromCurrency())
                .convertedAmount(exchangeTransaction.getConvertedAmount())
                .rate(exchangeTransaction.getRate())
                .build();
    }

}
