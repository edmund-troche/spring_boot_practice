package org.troche.spring.application.exercise.service;

import org.troche.spring.application.exercise.model.WordFrequencyAnalysis;

/**
 * Text analysis service.
 */
public interface TextAnalysisService {
    /**
     * Takes a paragraph of text and computes word frequencies.
     *
     * @param text text to analyze, not null.
     *
     * @returns a map where the keys are unique words found the {@code text}
     */
    public WordFrequencyAnalysis getWordFrequencies(final String text);
}
