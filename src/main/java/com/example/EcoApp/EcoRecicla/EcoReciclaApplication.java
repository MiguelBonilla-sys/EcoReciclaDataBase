package com.example.EcoApp.EcoRecicla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.EcoApp.EcoRecicla.Repositories")
@EntityScan("com.example.EcoApp.EcoRecicla.Models") // Add this line
public class EcoReciclaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcoReciclaApplication.class, args);
    }
}