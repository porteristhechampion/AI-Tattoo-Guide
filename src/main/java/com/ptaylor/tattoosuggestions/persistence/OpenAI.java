package com.ptaylor.tattoosuggestions.persistence;

import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openaiapi.AIResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class sends a request to the OpenAI API, feeds user input to the AI,
 * and returns the AI's response.
 *
 * @author ptaylor
 */
public class OpenAI implements PropertiesLoader {

    private static final Logger logger = LogManager.getLogger(OpenAI.class);

    private Properties properties;
    private String apiKey;
    private String apiUrl;
    private String model;

    /**
     * Constructor loads the properties file and the needed properties
     * into variables.
     */
    public OpenAI() {
        properties = loadProperties("/api.properties");

        apiKey = properties.getProperty("OPENAI_API_KEY");
        logger.info("OpenAI API Key: " + apiKey);
        apiUrl = properties.getProperty("OPENAI_API_URL");
        logger.info("OpenAI API URL: " + apiUrl);
        model = properties.getProperty("OPENAI_MODEL");
        logger.info("OpenAI MODEL: " + model);
    }

    /**
     * Sends a user message to the OpenAI API and retrieves the AI's reponse.
     *
     * This method constructs a request with the specified user input, sends it to the
     * OpenAI API and processes the JSON response to extract the AI's reply.
     *
     * @param message user input
     * @return AI response
     * @throws RuntimeException if the API request or response parseing fails
     */
    public String getAIResponse(String message) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(apiUrl);

            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";

            Invocation.Builder request = target.request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json");

            Response response = request.post(Entity.json(body));

            String jsonResponse = response.readEntity(String.class);

            ObjectMapper mapper = new ObjectMapper();

            AIResponse aiResponse = mapper.readValue(jsonResponse, AIResponse.class);

            logger.info(aiResponse.getChoices().get(0).getMessage().getContent());

            return aiResponse.getChoices().get(0).getMessage().getContent();
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

}
