package com.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class AdminProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminProviderApp.class,args);
    }
}
