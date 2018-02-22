package org.troche.spring.application.exercise.controller.v1;

import java.util.Locale;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;

import org.troche.spring.application.exercise.model.GreetingMessage;

/**
 * Controller to handle the HTTP requests for greetings.
 */
@RestController
public class GreeterController extends BaseController {
    /**
     * English greeting.
     */
    public static final String GREETING_TEXT_EN_US = "Hello World!";

    /**
     * Spanish greeting.
     */
    public static final String GREETING_TEXT_ES = "Hola Mundo!";

    /**
     * Method that will be called when issuing an HTTP GET on the URI path "/greeter".
     *
     * @return string that gets returned for the HTTP GET request.
     */
    @GetMapping(value = "/greeter", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> index(@RequestHeader(value = "content-language", defaultValue = "en-US") String contentLanguage) {
        final Locale LOCALE = Locale.forLanguageTag(contentLanguage);
        final GreetingMessage MESSAGE = new GreetingMessage(getGreetingText(LOCALE), LOCALE);

	return ResponseEntity.ok()
		.header("content-language", convertLocaleToContentLanguage(MESSAGE.getLocale().toString()))
		.body(new GreetingMessage(getGreetingText(LOCALE), LOCALE));
    }

    /**
     * Convert language tag to HTTP content-language format.
     */
    private String convertLocaleToContentLanguage(final String locale) {
        return locale.replace('_', '-');
    }

    /**
     * Get locale specific greeting.
     *
     * If the locale is not `en_US` or `es`|`es_SP` then use `en_US`.
     *
     * TODO: use a resource file for the per-language messages.
     */
    private String getGreetingText(final Locale locale) {
        if (locale.equals(Locale.US)) {
            return GREETING_TEXT_EN_US;
        } else if (locale.equals(new Locale.Builder().setLanguage("es").build()) ||
        	   locale.equals(new Locale.Builder().setLanguage("es").setRegion("SP").build())) {
            return GREETING_TEXT_ES;
	} else {
            return GREETING_TEXT_EN_US;
	}
    }
}
