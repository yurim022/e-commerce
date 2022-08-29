package com.example.apigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApigatewayServiceApplication {

    // run by asynchronous - using netty server
    public static void main(String[] args) {
        SpringApplication.run(ApigatewayServiceApplication.class, args);
    }

}
