package org.exchange.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConvertCurrencyResponse {

    private String base;
    private BigDecimal amount;
    private Map<String, BigDecimal> result;
    private Long ms;

}
