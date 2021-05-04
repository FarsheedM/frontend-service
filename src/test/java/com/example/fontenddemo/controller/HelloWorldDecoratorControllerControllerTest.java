package com.example.fontenddemo.controller;

import com.example.fontenddemo.service.HelloWorldDecoratorService;
import com.example.fontenddemo.utils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
class HelloWorldDecoratorControllerControllerTest {

    @Mock
    private HelloWorldDecoratorService helloWorldDecoratorService;

    @InjectMocks
    private HelloWorldDecoratorController helloWorldDecoratorController;

    @Test
    void controller_not_null(){
        assertNotNull(helloWorldDecoratorController);
    }
    @Test
    void controller_response_successfully() throws URISyntaxException {
        String expectedServiceValue = "hallo Welt"+ Constants.DECORATED_TEXT;
        when(helloWorldDecoratorService.decorateGreeting()).thenReturn(expectedServiceValue);
        ResponseEntity<String> response= helloWorldDecoratorController.decorateGreeting();
        HttpStatus actualStatusCode = response.getStatusCode();
        String actualBody = response.getBody();
        assertThat(actualStatusCode,is(HttpStatus.OK));
        assertThat(actualBody,is(expectedServiceValue));
    }
}
