package org.troche.spring.application.exercise.service;

import java.util.Objects;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.troche.spring.application.exercise.model.WordFrequencyAnalysis;

import org.springframework.stereotype.Service;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("textAnalysisService")
public class TextAnalysisServiceImpl implements TextAnalysisService {
    /**
     * Class-level logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TextAnalysisServiceImpl.class);

    /**
     * Takes a paragraph of text and computes word frequencies.
     *
     * @param text text to analyze, not null.
     *
     * @returns a map where the keys are unique words found the {@code text}
     */
    public WordFrequencyAnalysis getWordFrequencies(final String text) {
	LOGGER.info("word frequency analysis, analyzing text [{}]", text);

        Objects.requireNonNull(text, "text");

	// remove punctuation characters like ',', '!', '.', ''', '`', and '?'
	String sanitizedText  = text.replaceAll("['`,!\\.]", "");

	// treat all words the same regardless of case.
	sanitizedText = sanitizedText.toLowerCase();

	// word segmentation
        Scanner scanner = new Scanner(sanitizedText ).useDelimiter("\\s+");

	final Map<String, Integer> wordCount = new TreeMap<String, Integer>();
        while (scanner.hasNext()) {
            String key = scanner.next();
            Integer value = wordCount.get(key);
            wordCount.put(key, value == null ? new Integer(1) : ++value);
        }

	LOGGER.info("word frequency analysis, analysis [{}]", wordCount.toString());

	return new WordFrequencyAnalysis(wordCount);
    }
}
