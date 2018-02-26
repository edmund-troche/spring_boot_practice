package org.troche.spring.application.exercise;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class.
 */
@SpringBootApplication
public class Application {
    /**
     * Main entry point for the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        final SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
