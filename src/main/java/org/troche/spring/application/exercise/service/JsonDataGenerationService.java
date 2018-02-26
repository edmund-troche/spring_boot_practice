package org.troche.spring.application.exercise.service;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonDataGenerationService {
    private final int MAX_THREADS = 10;
    private final ExecutorService futureExecutor = Executors.newFixedThreadPool(MAX_THREADS);

    /**
     * Class-level logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDataGenerationService.class);

    /**
     * Calls the `https://jsonplaceholder.typicode.com/posts` endpoint
     * and returns the entity body as a {@code String}.
     *
     * @returns generated JSON data from typicode.com endpoint.
     */
    public CompletableFuture<String> getJsonData() {
        return CompletableFuture.supplyAsync(() -> {
            URI dataSourceUri = null;
            try {
                dataSourceUri = new URI("https://jsonplaceholder.typicode.com/posts");
            } catch (URISyntaxException usExc) {
                // Ignore, the URL is known to be a valid URI
            }

            String receivedData = null;
            try {
                receivedData = getDataFromUri(dataSourceUri);
            } catch (Exception exc) {
                // Ignore, the URL is known to be a valid URI
                System.out.println("Received exception: " + exc);
            }

            return receivedData;
        }, futureExecutor);
    }

    private String getDataFromUri(final URI dataSourceUri) {
        Objects.requireNonNull(dataSourceUri, "dataSourceUri");

        final RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(dataSourceUri, String.class);
    }
}
