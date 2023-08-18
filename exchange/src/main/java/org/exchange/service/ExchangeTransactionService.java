package org.exchange.service;

import org.exchange.dao.entity.ExchangeTransaction;
import org.exchange.dto.ConvertResponse;
import org.springframework.data.domain.Page;

public interface ExchangeTransactionService {

    ExchangeTransaction saveExchangeTransaction(ExchangeTransaction exchangeTransaction);

    Page<ConvertResponse> getPageableConvertTransactions(int page, int pageSize, String transactionId, Long transactionDate);
}
