package com.example.springbootessentials.service;

import com.example.springbootessentials.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * ✅ Loads only when 'prod' profile is active.
 */
@Profile("prod")
@Service
public class ProdWelcomeService implements WelcomeService {

    private final AppProperties appProperties;

    @Autowired
    public ProdWelcomeService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public String getWelcomeMessage() {
        // 🎯 Dynamic message loaded from YAML (application-prod.yml)
        return "🏢 " + appProperties.getMessage();
    }

    @Override
    public String getTitle() {
        // 🎯 Dynamic title loaded from YAML (application-prod.yml)
        return "🏢 " + appProperties.getTitle();
    }
}
