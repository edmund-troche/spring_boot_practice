package org.troche.spring.application.exercise.service;

import org.junit.Test;

/**
 * Test suite for the TextAnalysisServiceImpl class.
 */
public class TextAnalysisServiceImplTest {

    /**
     * Test that the getWordFrequencies method works with valid input.
     */
    @Test
    public void testGetWordFrequencies() {
       final TextAnalysisService txtAnalysisService = new TextAnalysisServiceImpl();

       final String text = "Much did had call new drew that kept Limits expect wonder law she Now has you views woman noisy match money rooms To up remark it eldest length oh passed Off because yet mistake feeling has men Consulted disposing to moonlight ye extremity Engage piqued in on coming";

       txtAnalysisService.getWordFrequencies(text);
    }

    /**
     * Test that the getWordFrequencies method fails with invalid input.
     */
    @Test (expected = NullPointerException.class)
    public void testConstructorInvalidMessage() {
        final TextAnalysisService txtAnalysisService = new TextAnalysisServiceImpl();

       txtAnalysisService.getWordFrequencies(null);
    }
}
