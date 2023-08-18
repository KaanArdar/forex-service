package org.exchange.config;

import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exchange.client.config.ForexException;
import org.exchange.dto.ErrorResponse;
import org.exchange.utility.MessageSourceUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@AllArgsConstructor
public class ResponseErrorHandler {

    private final MessageSourceUtil messageSourceUtil;

    @ExceptionHandler(ForexException.class)
    public ResponseEntity<ErrorResponse> handleForexException(ForexException exception) {
        log.error("Forex API Exception occurred", exception);
        return ResponseEntity.ok(ErrorResponse.builder()
                .code(exception.getStatusCode())
                .message(messageSourceUtil.getMessageFromSource(String.valueOf(exception.getStatusCode())))
                .build());
    }


}
