package org.troche.spring.application.exercise.controller.v1;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.troche.spring.application.exercise.service.JsonDataGenerationService;

// TODO Try reactor.core
// import reactor.core.publisher.Mono;

@RestController
public class ApiGatewayController extends BaseController {
    private final JsonDataGenerationService jsonDataGenerationService;

    @Autowired
    public ApiGatewayController(JsonDataGenerationService jsonDataGenerationService) {
        this.jsonDataGenerationService =
                Objects.requireNonNull(jsonDataGenerationService, "jsonDataGenerationService");
    }

    @GetMapping("/gateway")
    public CompletableFuture<String> generateJsonData() {
        return this.jsonDataGenerationService.getJsonData();
    }
}
