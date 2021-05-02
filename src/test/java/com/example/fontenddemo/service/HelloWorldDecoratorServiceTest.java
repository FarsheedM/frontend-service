package com.example.fontenddemo.service;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URISyntaxException;

import static com.example.fontenddemo.utils.Constants.DECORATED_TEXT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(value = MockitoExtension.class)
class HelloWorldDecoratorServiceTest {

    @InjectMocks
    private HelloWorldDecoratorService helloWorldDecoratorService;

    @Test
    void service_not_null(){
        assertNotNull(helloWorldDecoratorService);
    }

    @Disabled("TODO: find a way to use application properties and invoke WebClient")
    @Test
    void service_tinker_the_greeting_correnctly() throws URISyntaxException {
        //Todo: this test should be modified
        String decoratedGreeting= "hallo Welt"+ DECORATED_TEXT;
        String actualResult = helloWorldDecoratorService.decorateGreeting();
        assertThat(actualResult,is(decoratedGreeting));
    }

}
