package org.exchange.service.impl;

import lombok.RequiredArgsConstructor;

import org.exchange.client.ForexClient;
import org.exchange.client.response.ConvertCurrencyResponse;
import org.exchange.dao.entity.ExchangeTransaction;
import org.exchange.dto.ConvertResponse;
import org.exchange.dto.RateResponse;
import org.exchange.mapper.ConvertResponseMapper;
import org.exchange.mapper.ExchangeTransactionEntityMapper;
import org.exchange.mapper.RateResponseMapper;
import org.exchange.service.ExchangeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final ForexClient forexClient;
    private final ExchangeTransactionServiceImpl exchangeTransactionServiceImpl;


    @Override
    public RateResponse exchangeRate(String fromCurrency, String toCurrency) {
        return RateResponseMapper.toMap(toCurrency, forexClient.exchangeRate(fromCurrency, toCurrency));
    }

    @Override
    public ConvertResponse convertCurrency(String fromCurrency, String toCurrency, BigDecimal amount) {
        ConvertCurrencyResponse convertCurrencyResponse = forexClient.convertCurrency(fromCurrency, toCurrency, amount);
        ExchangeTransaction exchangeTransaction =
                exchangeTransactionServiceImpl.saveExchangeTransaction(ExchangeTransactionEntityMapper.toEntity(toCurrency, convertCurrencyResponse));
        return ConvertResponseMapper.toMap(exchangeTransaction);
    }

}
