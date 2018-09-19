package org.troche.spring.application.exercise.model;

import java.util.Objects;

/** Representation of natural language text. */
public class NaturalLanguageText {
    /** Actual text, not null. */
    private String text;

    public NaturalLanguageText() {}

    /**
     * Constructs a new natural-language-text object with the specified text and locale.
     *
     * @param text Actual natural language text, not null.
     * @throws NullPointerException if {@code text} is null.
     */
    public NaturalLanguageText(final String text) throws NullPointerException {
        setText(Objects.requireNonNull(text, "text"));
    }

    /** Gets the text, not null. */
    public String getText() {
        return text;
    }

    /** Set the text, not null. */
    public void setText(final String text) {
        this.text = Objects.requireNonNull(text);
    }

    /** Compute hash code for this. */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = PRIME + (int) (text.hashCode() ^ (text.hashCode() >>> 32));

        return result;
    }

    /** Determine if obj is equal to this. */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        NaturalLanguageText other = (NaturalLanguageText) obj;
        if (!text.equals(other.text)) {
            return false;
        }

        return true;
    }

    /**
     * Returns the string representation of this natural-language-text.
     *
     * @returns String string representation of this.
     */
    @Override
    public String toString() {
        return String.format("{\"text\": \"%s\"}", text);
    }
}
