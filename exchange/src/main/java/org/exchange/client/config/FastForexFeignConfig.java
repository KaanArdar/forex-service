package org.exchange.client.config;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.exchange.client.api.FastForexApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FastForexFeignConfig {

    private final FastForexConfig fastForexConfig;

    @Bean
    public FastForexApi fastForexApi(OkHttpClient okHttpClient, Request.Options options) {
        return Feign.builder()
                .client(new feign.okhttp.OkHttpClient(okHttpClient))
                .retryer(Retryer.NEVER_RETRY)
                .options(options)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new FastForexErrorDecoder())
                .target(FastForexApi.class, fastForexConfig.getFastForexBaseUrl());
    }

}
