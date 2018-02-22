package org.troche.spring.application.exercise;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Main Spring Boot application class.
 */
@SpringBootApplication
public class Application {
    /** logger for the Application class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * Main entry point for the application.
     *
     * @param args   command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    /**
     * This runs on start up to retrieve all the beans that were created
     * either by the app or were automatically added thanks to Spring Boot.
     * It sorts them and prints them out.
     *
     * @param ctx Spring Boot application context
     *
     * @return the CommandLineRunner instance
     */
    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {
            LOGGER.info("Bean definition names:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                LOGGER.info(beanName);
            }
        };
    }
}
