package com.coder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.coder")
public class ApplicationStart {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationStart.class, args);
    }
}