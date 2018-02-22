package org.troche.spring.application.exercise.controller.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;

import org.troche.spring.application.exercise.exception.InvalidQueryParameter;
import org.troche.spring.application.exercise.model.NaturalLanguageText;
import org.troche.spring.application.exercise.model.WordFrequencyAnalysis;
import org.troche.spring.application.exercise.service.TextAnalysisService;

/**
 * Controller to handle the HTTP requests for mathematical operations.
 */
@RestController
public class MathController extends BaseController {
    private static final String CONTROLLER_BASE_PATH = "/math";
    private static final int MAX_FIBONACCI_TERMS = 40;

    /**
     * Handler for HTTP POST request on the URI path "/fibonacci".
     *
     * Compute Fibonacci numbers and return a JSON doc with an array of the first N terms.
     *
     * @return first N Fibonnaci numbers.
     */
    @GetMapping(value = CONTROLLER_BASE_PATH + "/fibonacci")
    public ResponseEntity<?> computeFibonnaciNumbers(@RequestParam("numTerms") int numTerms) {
	if (numTerms < 0 || numTerms >= MAX_FIBONACCI_TERMS) {
	    throw new InvalidQueryParameter("parameter `numTerms` must be between 0 and " 
		+ MAX_FIBONACCI_TERMS + ", specified value is [" + numTerms + "].");
	}

	final List<Long> fibSequence = computeFibonacciSequence(numTerms);

	return ResponseEntity.ok().body(fibSequence);
    }

    private static List<Long> computeFibonacciSequence(final int numTerms) {
        final List<Long> fibSequence = new ArrayList<Long>();

	for (int termNum = 0; termNum < numTerms; termNum++) {
	    fibSequence.add(computeFibonacciTerm(termNum));
	}

	return fibSequence;
    }

    private static long computeFibonacciTerm(final int termNum) {
    	if (termNum == 0) {
	    return 0;
	} else if (termNum <= 2) {
	    return 1;
	} else {
            long fibTerm = computeFibonacciTerm(termNum - 1) + computeFibonacciTerm(termNum - 2);

	    return fibTerm;
	}
    }
}
