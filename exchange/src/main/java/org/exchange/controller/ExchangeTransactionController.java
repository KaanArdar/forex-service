package org.exchange.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exchange.dto.ConvertResponse;
import org.exchange.dto.RateResponse;
import org.exchange.service.ExchangeTransactionService;
import org.exchange.service.impl.ExchangeServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange-transaction")
public class ExchangeTransactionController {

    private final ExchangeTransactionService exchangeTransactionService;

    @GetMapping()
    public ResponseEntity<Page<ConvertResponse>> getConvertTransactionList(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                                           @RequestParam(value = "transactionId", required = false) String transactionId,
                                                                           @RequestParam(value = "transactionDate", required = false) Long transactionDate) {
        return ResponseEntity.ok(
                exchangeTransactionService.getPageableConvertTransactions(page, pageSize, transactionId, transactionDate)
        );
    }

}
