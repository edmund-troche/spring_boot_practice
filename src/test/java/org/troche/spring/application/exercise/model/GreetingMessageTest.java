package org.troche.spring.application.exercise.model;

import java.util.Locale;

import org.junit.Test;

/**
 * Test suite for the GreetingMessage class.
 */
public class GreetingMessageTest {

    /**
     * Test that the constructor succeeds with valid parameters.
     */
    @Test
    public void testConstructorValidParams() {
        new GreetingMessage("Valid message", Locale.getDefault());
    }

    /**
     * Test that the constructor fails with invalid message.
     */
    @Test (expected = NullPointerException.class)
    public void testConstructorInvalidMessage() {
        new GreetingMessage(null, Locale.getDefault());
    }

    /**
     * Test that the constructor fails with invalid locale.
     */
    @Test (expected = NullPointerException.class)
    public void testConstructorInvalidLocale() {
        new GreetingMessage("Valid message", null);
    }
}
