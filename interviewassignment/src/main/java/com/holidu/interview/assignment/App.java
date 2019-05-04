package com.holidu.interview.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.holidu.interview.assignment.search", "com.holidu.interview.assignment.service", "com.holidu.interview.assignment.support"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}