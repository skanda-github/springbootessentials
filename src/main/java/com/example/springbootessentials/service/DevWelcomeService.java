package com.example.springbootessentials.service;

import com.example.springbootessentials.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * ✅ Loads only when 'dev' profile is active.
 */
@Profile("dev")
@Service
public class DevWelcomeService implements WelcomeService {

    private final AppProperties appProperties;

    // ✅ Constructor Injection of AppProperties
    @Autowired
    public DevWelcomeService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public String getWelcomeMessage() {
        // 🎯 Dynamic message loaded from YAML (application-dev.yml)
        return "👨‍💻 " + appProperties.getMessage();
    }

    @Override
    public String getTitle() {
        // 🎯 Dynamic title loaded from YAML (application-dev.yml)
        return "👨‍💻 " + appProperties.getTitle();
    }
}

