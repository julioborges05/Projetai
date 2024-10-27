package com.projetai.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.projetai.customer",
                "com.projetai.quality",
                "com.projetai.development",
                "com.projetai.api"
        })
@EntityScan(
        basePackages = {
                "com.projetai.customer",
                "com.projetai.quality",
                "com.projetai.development",
                "com.projetai.api"
        })
@EnableJpaRepositories(
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