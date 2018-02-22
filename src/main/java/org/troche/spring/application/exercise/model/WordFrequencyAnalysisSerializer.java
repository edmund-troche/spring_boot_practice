package org.troche.spring.application.exercise.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.util.Map;
import java.io.IOException;

/**
 * Custom serializer for {@code WordFrequencyAnalysis}.
 */
public class WordFrequencyAnalysisSerializer extends StdSerializer<WordFrequencyAnalysis> {
    public WordFrequencyAnalysisSerializer() {
        this(null);
    }
   
    public WordFrequencyAnalysisSerializer(Class<WordFrequencyAnalysis> t) {
        super(t);
    }
 
    @Override
    public void serialize(WordFrequencyAnalysis value, JsonGenerator jsonGen, SerializerProvider provider) 
             throws IOException, JsonProcessingException {

	jsonGen.writeStartArray();
        for (Map.Entry<String, Integer> entry : value.getWordFrequency().entrySet()) {
            jsonGen.writeStartObject();
            jsonGen.writeNumberField(entry.getKey(), entry.getValue());
            jsonGen.writeEndObject();
        }
	jsonGen.writeEndArray();
    }
}
