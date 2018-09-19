package org.troche.spring.application.exercise.model;

import java.util.Locale;
import java.util.Objects;

/** Class to hold the greeting message and corresponding language. */
public class GreetingMessage {
    /** Actual greeting message. */
    private final String content;

    /** Language used for the greeting message. */
    private final Locale locale;

    /**
     * Create a GreetingMessage object that has a content and language.
     *
     * @param aContent actual greeting message
     * @param aLocale language used for the message
     */
    public GreetingMessage(final String aContent, final Locale aLocale) {
        this.content = Objects.requireNonNull(aContent, "content");
        this.locale = Objects.requireNonNull(aLocale, "locale");
    }

    /**
     * Retrieve the greeting text.
     *
     * @return greeting text.
     */
    public String getContent() {
        return content;
    }

    /**
     * Retrieve the locale used in the greeting.
     *
     * @return greeting locale
     */
    public Locale getLocale() {
        return locale;
    }
}
