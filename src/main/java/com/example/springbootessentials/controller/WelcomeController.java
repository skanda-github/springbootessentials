// File: controller/WelcomeController.java

package com.example.springbootessentials.controller;

import com.example.springbootessentials.config.AppProperties;
import com.example.springbootessentials.service.WelcomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST endpoint that demonstrates:
 * - Use of constructor injection
 * - Profile-based service loading (dev/prod)
 * - Reading dynamic values from configuration (YAML)
 */
@RestController
public class WelcomeController {

    private final WelcomeService welcomeService;

    // ✅ Constructor Injection ensures immutability and testability
    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        // 🎯 Dynamically reads message from the appropriate profile and app config
        return welcomeService.getWelcomeMessage();
    }

    @GetMapping("/title")
    public String getTitle() {
        // 📝 Reads the title property from the YAML config
        return "📘 App Title from YAML: " + welcomeService.getTitle();
    }
}