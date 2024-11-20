package com.example.lab3_java_ee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.lab3_java_ee")
@EnableJpaRepositories(basePackages = "com.example.lab3_java_ee")
public class Lab3JavaEeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab3JavaEeApplication.class, args);
    }

}
