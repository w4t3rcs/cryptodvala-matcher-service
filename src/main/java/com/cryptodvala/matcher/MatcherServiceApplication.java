package com.cryptodvala.matcher;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@EnableAdminServer
@SpringBootApplication
public class MatcherServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MatcherServiceApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }
}
