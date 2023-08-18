package org.exchange.utility;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageSourceUtil {

    private final MessageSource messageSource;

    public String getMessageFromSource(final String code, final Object... args) {
        try {
            return messageSource.getMessage(code, args, Locale.US);
        } catch (Exception e) {
            log.warn("MessageSourceUtil@getMessageFromSource code: {} exception: {}", code, e.getMessage());
            return code;
        }
    }

}