package com.example.section4_task13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Section4Task13Application {
    @Autowired
    private Calculator calculator;

    public static void main(String[] args) {
        SpringApplication.run(Section4Task13Application.class, args);
    }

    @Bean
    public void outToConsole() {
        System.out.print("Result: ");
        calculator.calc(2, 3);
    }
}
