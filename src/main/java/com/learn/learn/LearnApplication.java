package com.learn.learn;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        // Load environment variables from .env file only in development
        Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing() // Ignore if .env file is not found
            .load();

        // Set the environment variables to System properties
        dotenv.entries().forEach(entry -> {
            String key = entry.getKey();
            // Only set the variable if it's not already set in the system environment
            if (System.getenv(key) == null) {
                System.setProperty(key, entry.getValue());
            }
        });

        // Start the Spring Boot application
        SpringApplication.run(LearnApplication.class, args);
    }
}
