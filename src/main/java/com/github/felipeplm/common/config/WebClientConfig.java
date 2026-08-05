package com.github.felipeplm.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    /**
     * Bean do WebClient padrão para consumo de APIs externas.
     * @return WebClient padrão
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .build();
    }
}
