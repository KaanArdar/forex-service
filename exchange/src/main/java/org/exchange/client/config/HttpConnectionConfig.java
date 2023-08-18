package org.exchange.client.config;

import feign.Request;
import lombok.Getter;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Getter
@Configuration
public class HttpConnectionConfig {

    @Value("${http.max-total-connections}")
    private Integer maxTotalConnections;

    @Value("${http.read-time-out}")
    private Integer readTimeOut;

    @Value("${http.keep-alive-duration}")
    private Integer keepAliveDuration;

    @Value("${http.connect-timeout}")
    private Integer connectTimeOut;

    @Bean
    public Request.Options requestOptions() {
        return new Request.Options(readTimeOut, TimeUnit.MILLISECONDS, connectTimeOut, TimeUnit.MILLISECONDS, true);
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectionPool(new ConnectionPool(maxTotalConnections, keepAliveDuration, TimeUnit.MILLISECONDS))
                .build();
    }

}
