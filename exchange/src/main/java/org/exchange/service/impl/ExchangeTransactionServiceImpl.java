package org.exchange.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exchange.dao.entity.ExchangeTransaction;
import org.exchange.dao.repository.ExchangeTransactionRepository;
import org.exchange.dto.ConvertResponse;
import org.exchange.mapper.ConvertResponseMapper;
import org.exchange.service.ExchangeTransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.exchange.dao.repository.ExchangeTransactionRepository.getSpec;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeTransactionServiceImpl implements ExchangeTransactionService {

    private final ExchangeTransactionRepository exchangeTransactionRepository;

    @Override
    public ExchangeTransaction saveExchangeTransaction(ExchangeTransaction exchangeTransaction) {
        ExchangeTransaction transaction = exchangeTransactionRepository.save(exchangeTransaction);
        log.info("exchange transaction completed transaction Id: {}", transaction.getId());
        return transaction;
    }

    @Override
    public Page<ConvertResponse> getPageableConvertTransactions(int page, int pageSize, String transactionId, Long transactionDate) {
        final PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.Direction.DESC,
                "transactionDate");

        Page<ExchangeTransaction> pageable = exchangeTransactionRepository.findAll(getSpec(transactionId, transactionDate), pageRequest);

        List<ConvertResponse> collect = pageable.getContent()
                .stream().map(ConvertResponseMapper::toMap)
                .toList();

        return new PageImpl<>(
                collect,
                pageRequest,
                pageable.getTotalElements());

    }
}
