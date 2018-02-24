package org.troche.spring.application.exercise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.troche.spring.application.exercise.service.DeviceManagementService;
import org.troche.spring.application.exercise.service.DeviceManagementServiceImpl;

/**
 * Main Spring Boot configuration class for the exercise app.
 */
@Configuration
@ComponentScan("org.troche.spring.application.exercise")
public class ApplicationConfiguration {

    @Bean
    public DeviceManagementService deviceManagementService() {
            return new DeviceManagementServiceImpl();
    }
}
