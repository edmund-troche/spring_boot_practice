package org.troche.spring.application.exercise.controller.v1;

import java.util.concurrent.CompletableFuture;
import java.util.Locale;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.troche.spring.application.exercise.service.JsonDataGenerationService;

//import reactor.core.publisher.Mono;

@RestController
public class ApiGatewayController extends BaseController {
    private final JsonDataGenerationService jsonDataGenerationService;

    @Autowired
    public ApiGatewayController(JsonDataGenerationService jsonDataGenerationService) {
        System.out.println("injecting JSON data generation service");

        this.jsonDataGenerationService = Objects.requireNonNull(jsonDataGenerationService,
            "jsonDataGenerationService");
    }

    @GetMapping("/gateway")
    public CompletableFuture<String> generateJsonData() {
        return this.jsonDataGenerationService.getJsonData();
    }
}
