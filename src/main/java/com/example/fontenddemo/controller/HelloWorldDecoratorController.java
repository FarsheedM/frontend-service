package com.example.fontenddemo.controller;

import com.example.fontenddemo.service.HelloWorldDecoratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController("/")
public class HelloWorldDecoratorController {

    @Autowired
    private HelloWorldDecoratorService helloWorldDecoratorService;
    @GetMapping
    public ResponseEntity<String> decorateGreeting() throws URISyntaxException {
        String decoratedGreetingRetrievedFromOtherService= helloWorldDecoratorService.decorateGreeting();
        return new ResponseEntity<>(decoratedGreetingRetrievedFromOtherService, HttpStatus.OK);
    }
}
