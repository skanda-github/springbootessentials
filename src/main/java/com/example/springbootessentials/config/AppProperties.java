package com.example.springbootessentials.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ✅ This class maps the 'app' configuration properties from YAML files into a strongly typed Java object.
 *
 * 📌 Example YAML:
 *     app:
 *       title: "StudentPortal"
 *       message: "Welcome from Dev Environment 🎯"
 */
@Configuration  // 🔧 Marks this class as a Spring-managed configuration bean
@ConfigurationProperties(prefix = "app")  // 🔍 Binds all properties under 'app.*' from YAML to this class
public class AppProperties {
    // 🔑 These fields will be mapped from app.title and app.message respectively
    private String title;
    private String message;

    // 🧱 Getter for 'title' property (used to access the value in other parts of the app)
    public String getTitle() {
        return title;
    }

    // 🧱 Setter for 'title' property (used by Spring Boot to inject value from YAML)
    public void setTitle(String title) {
        this.title = title;
    }

    // 🧱 Getter for 'message' property (used in controller/service layers)
    public String getMessage() {
        return message;
    }

    // 🧱 Setter for 'message' property (used by Spring Boot during property binding)
    public void setMessage(String message) {
        this.message = message;
    }
}
