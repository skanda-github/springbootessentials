// File: config/WebMvcConfig.java

package com.example.springbootessentials.config;

import com.example.springbootessentials.interceptor.ExecutionTimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class that registers custom interceptors.
 * 
 * Implements WebMvcConfigurer to hook into Spring's MVC setup.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * Adds our custom ExecutionTimeInterceptor to the application's interceptor registry.
     * 
     * This method is automatically called by Spring Boot during startup.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ExecutionTimeInterceptor())
                .addPathPatterns("/**"); // 🌐 Apply to all request paths
    }
}
