package com.example.springbootessentials.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;

import com.example.springbootessentials.filter.RequestLoggingFilter;

/**
 * This class manually registers the RequestLoggingFilter as a bean.
 * Useful if you want full control over filter registration, such as ordering or URL pattern mapping.
 * Even though we are not injecting this bean manually, Spring Boot automatically detects Filter beans,
 * and registers them into the servlet filter chain during application startup.
 * This allows our RequestLoggingFilter to intercept all HTTP requests.
 */
@Configuration
public class FilterConfig {

    /**
     * Registers RequestLoggingFilter as a Spring Bean.
     * This method will be picked up by Spring during startup.
     *
     * @return a Filter instance (specifically, our RequestLoggingFilter)
     */
    @Bean
    public Filter loggingFilter() {
        return new RequestLoggingFilter();
    }
}