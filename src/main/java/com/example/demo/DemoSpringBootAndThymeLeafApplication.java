package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@ComponentScan(basePackages = {"com.example.controller", "com.example.service", "com.example.repository"})
//@EnableJpaRepositories(basePackages = {"com.example.repository"})
@SpringBootApplication
@EntityScan(basePackages = {"com.example.entity"})
public class DemoSpringBootAndThymeLeafApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootAndThymeLeafApplication.class, args);
    }

}
