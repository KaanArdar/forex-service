package org.exchange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConvertResponse {

    private String transactionId;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal rate;
    private BigDecimal convertedAmount;

}
