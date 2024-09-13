package br.com.learn.chenrique.spring_learn_jwt.config.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExternalConfig {

    @Bean
    RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
