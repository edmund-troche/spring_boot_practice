package org.troche.spring.application.exercise;

import java.util.Arrays;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Main Spring Boot application class.
 */
@SpringBootApplication
//@Import(WebFluxAutoConfiguration.WebFluxConfig.class)
public class Application {
    /** logger for the Application class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * Main entry point for the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
    	//ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        //DeviceManagementService 	dms = context.getBean(DeviceManagementService.class);

        final SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @PostConstruct
	public void logSomething() {
		LOGGER.info("post construct app");
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
            //LOGGER.info("Bean definition names:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                //LOGGER.info(beanName);
                //System.out.println(beanName);
            }
        };
    }
}
