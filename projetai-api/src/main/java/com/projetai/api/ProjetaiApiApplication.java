package com.projetai.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.projetai.customer",
                "com.projetai.quality",
                "com.projetai.development",
                "com.projetai.api"
        })
public class ProjetaiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetaiApiApplication.class, args);
    }
}