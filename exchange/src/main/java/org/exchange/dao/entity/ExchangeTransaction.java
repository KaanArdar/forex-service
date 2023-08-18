package org.exchange.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ExchangeTransaction.EXCHANGE_TRANSACTION)
public class ExchangeTransaction implements Serializable {

    public static final String EXCHANGE_TRANSACTION = "exchange_transaction";
    private static final String ID = "id";
    private static final String FROM_CURRENCY = "from_currency";
    private static final String TO_CURRENCY = "to_currency";
    private static final String AMOUNT = "amount";
    private static final String RATE = "rate";
    private static final String CONVERTED_AMOUNT = "converted_amount";
    private static final String TRANSACTION_DATE = "transaction_date";

    @Id
    @Column(name = ExchangeTransaction.ID)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = ExchangeTransaction.FROM_CURRENCY)
    private String fromCurrency;

    @Column(name = ExchangeTransaction.TO_CURRENCY)
    private String toCurrency;

    @Column(name = ExchangeTransaction.AMOUNT)
    private BigDecimal amount;

    @Column(name = ExchangeTransaction.RATE)
    private BigDecimal rate;

    @Column(name = ExchangeTransaction.CONVERTED_AMOUNT)
    private BigDecimal convertedAmount;

    @Column(name = ExchangeTransaction.TRANSACTION_DATE)
    private Long transactionDate;

}
