package org.troche.spring.application.exercise.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/** Representation of a word frequency distribution. */
@JsonSerialize(using = WordFrequencyAnalysisSerializer.class)
public class WordFrequencyAnalysis {
    /**
     * Word and frequency storage.
     *
     * <p>Keys will be sorted according to natural ordering.
     */
    private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

    /** Constructs a new word-frequency-analysis object. */
    public WordFrequencyAnalysis() {}

    public WordFrequencyAnalysis(final Map<String, Integer> wordFrequency) {
        setWordFrequency(wordFrequency);
    }

    /** Set the word frequency data. */
    public void setWordFrequency(final Map<String, Integer> wordFrequency) {
        this.wordFrequency = Objects.requireNonNull(wordFrequency, "wordFrequency");
    }

    /** Get the word frequency data. */
    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    /**
     * Returns the string representation of this natural-language-text.
     *
     * @returns String string representation of this.
     */
    @Override
    public String toString() {
        return wordFrequency.toString();
    }
}
