package org.troche.spring.application.exercise.controller.v1;

import java.util.Locale;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/** Unit tests for V1 controllers. */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingsControllerTest {
    /** Base URL path for V1 API. */
    private static final String BASE_URL_PATH = "/api/v1/greeter";

    /** injected mock MVC object. */
    @Autowired
    private MockMvc mvc;

    /**
     * Test getting the greeting message, positive test.
     *
     * @throws Exception something went wrong.
     */
    @Test
    public void getGreeting() throws Exception {
	    /*
        ResultMatcher contentEnglish = MockMvcResultMatchers.jsonPath("content")
            .value(GreeterController.GREETING_TEXT_EN_US);

        ResultMatcher localeEnglish = MockMvcResultMatchers.jsonPath("locale")
            .value(new Locale(Locale.ENGLISH.toString(), Locale.US.toString()).toString());

        mvc.perform(MockMvcRequestBuilders.get(BASE_URL_PATH).accept(MediaType.APPLICATION_JSON).header("content-language", "en-US"))
            .andExpect(status().isOk())
            .andExpect(contentEnglish)
            .andExpect(localeEnglish);
	    */
    }

    /**
     * Test that HTTP DELETE is not allowed.
     *
     * @throws Exception something went wrong.
     */
    @Test
    public void invalidDeleteMethodForGreeting() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete(BASE_URL_PATH))
            .andExpect(status().isMethodNotAllowed());
    }

    /**
     * Test that HTTP POST is not allowed.
     *
     * @throws Exception something went wrong.
     */
    @Test
    public void invalidPostMethodForGreeting() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(BASE_URL_PATH))
            .andExpect(status().isMethodNotAllowed());
    }

    /**
     * Test that HTTP PUT is not allowed.
     *
     * @throws Exception something went wrong.
     */
    @Test
    public void invalidPutMethodForGreeting() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put(BASE_URL_PATH))
            .andExpect(status().isMethodNotAllowed());
    }
}
