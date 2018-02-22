package org.troche.spring.application.exercise.controller.v1;

import java.util.Locale;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import org.troche.spring.application.exercise.model.NaturalLanguageText;
import org.troche.spring.application.exercise.model.WordFrequencyAnalysis;
import org.troche.spring.application.exercise.service.TextAnalysisService;

/**
 * Controller to handle the HTTP requests for word frequency analysis.
 */
@RestController
public class TextAnalysisController extends BaseController {
    /**
     * Service that performs analysis of natural language text.
     */
    @Autowired
    TextAnalysisService textAnalysisService;
 
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
