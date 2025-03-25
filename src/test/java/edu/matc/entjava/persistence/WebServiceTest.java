package edu.matc.entjava.persistence;

import edu.matc.entjava.controller.OpenAI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class for web service interactions, specifically testing OpenAI responses.
 *
 * @author ptaylor
 */
public class WebServiceTest{

    /**
     * Tests the OpenAI response to ensure it is not null.
     */
    @Test
    public void testOpenAIResponse() {
        OpenAI openai = new OpenAI();
        String response = openai.getAIResponse("Give me a tattoo idea about music.");
        assertNotNull(response);
        assertTrue(response.length() < 500);
    }

}
