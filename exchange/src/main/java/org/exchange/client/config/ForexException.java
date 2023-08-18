package org.exchange.client.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ForexException extends RuntimeException {
    private int statusCode;
    private String message;
}
