package com.example.fontenddemo.service;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;
import org.springframework.web.reactive.function.client.WebClient;

import static com.example.fontenddemo.utils.Constants.DECORATED_TEXT;

/**
 * this service retrieves the "greeting" text from another service and wrap/decorate it
 */
@Service
@SuppressWarnings("java:S6212")
public class HelloWorldDecoratorService {

    @Value("${interapp.backend.url:localhost:8080/greeting}")
    private String backendDemoUrl;

    private static final Logger log= LogManager.getLogger();


    public String decorateGreeting() {
        log.info("The backend-demo URL: {}",backendDemoUrl);
        WebClient webClient = WebClient.create(backendDemoUrl);
        String greetingTextFromBackendDemo = webClient
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return greetingTextFromBackendDemo+DECORATED_TEXT;
    }
}
