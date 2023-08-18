package org.exchange.client.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class FastForexConfig {

    @Value("${fast-forex.url}")
    private String fastForexBaseUrl;

    @Value("${fast-forex.apiKey}")
    private String fastForexApiKey;

}
