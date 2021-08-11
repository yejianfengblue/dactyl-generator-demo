package com.example.dactylgeneratordemo;

import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
public class RestTemplateConfig {

    @Bean
    @ConditionalOnProperty(name = "proxy")
    public RestTemplateCustomizer restTemplateProxyCustomizer(@Value("${proxy}") String proxy) {

        return restTemplate -> {

            HttpRoutePlanner routePlanner = new DefaultProxyRoutePlanner(HttpHost.create(proxy));
            CloseableHttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(routePlanner).build();
            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
