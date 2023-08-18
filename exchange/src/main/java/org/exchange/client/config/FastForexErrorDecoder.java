package org.exchange.client.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FastForexErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        log.error("Fast forex error handler response {}", response);
        final int status = response.status();
        throw new ForexException(status, response.reason());
    }

}
