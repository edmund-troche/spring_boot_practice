package org.troche.spring.application.exercise.controller.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.troche.spring.application.exercise.model.NaturalLanguageText;
import org.troche.spring.application.exercise.service.TextAnalysisService;

/** Controller to handle the HTTP requests for word frequency analysis. */
@RestController
public class TextAnalysisController extends BaseController {
    /** Service that performs analysis of natural language text. */
    @Autowired TextAnalysisService textAnalysisService;

    /**
     * Handler for HTTP POST request on the URI path "/word_frequency".
     *
     * @return sorted list of unique words and their frequency.
     */
    @PostMapping(value = "/word_frequency")
    public ResponseEntity<?> computeWordFrequency(
            @RequestBody NaturalLanguageText naturalLanguageText) {
        return ResponseEntity.ok()
                .body(textAnalysisService.getWordFrequencies(naturalLanguageText.getText()));
    }
}
