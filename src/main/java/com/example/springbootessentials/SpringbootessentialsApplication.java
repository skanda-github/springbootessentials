// File: SpringbootessentialsApplication.java

package com.example.springbootessentials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 🧠 This is the main class that bootstraps the Spring Boot application.
 * It auto-configures everything and starts the embedded servlet container (Tomcat by default).
 */
@SpringBootApplication
public class SpringbootessentialsApplication {

    public static void main(String[] args) {
        // 🚀 Entry point to start the Spring Boot app
        SpringApplication.run(SpringbootessentialsApplication.class, args);
    }
}
