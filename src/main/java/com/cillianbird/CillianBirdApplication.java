package com.cillianbird;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation enables auto-configuration, component scanning, and serves as the entry point.
@SpringBootApplication
public class CillianBirdApplication {
    public static void main(String[] args) {
        SpringApplication.run(CillianBirdApplication.class, args);
    }
}