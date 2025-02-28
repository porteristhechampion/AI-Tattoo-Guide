package edu.matc.entjava.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import edu.matc.entjava.persistence.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenAI implements PropertiesLoader {

    private static final Logger logger = LogManager.getLogger(OpenAI.class);

    private Properties properties;
    private String apiKey;
    private String apiUrl;
    private String model;

    public OpenAI() {
        properties = loadProperties("/api.properties");

        apiKey = properties.getProperty("OPENAI_API_KEY");
        logger.info("OpenAI API Key: " + apiKey);
        apiUrl = properties.getProperty("OPENAI_API_URL");
        logger.info("OpenAI API URL: " + apiUrl);
        model = properties.getProperty("OPENAI_MODEL");
        logger.info("OpenAI MODEL: " + model);
    }

    // main class for testing purposes
//    public static void main(String[] args) {
//        OpenAI openAI = new OpenAI();
//        openAI.getAIResponse("Give me a tattoo idea about playing cards.");
//    }

    public String getAIResponse(String message) {

        try {
            URL urlObj = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";
            con.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String result = extractAIResponse(response.toString());

            logger.info(result);

            return result;

        } catch (IOException ioException) {
            logger.error(ioException);

            return "Error: Unable to get AI response";
        }
    }

    public String extractAIResponse(String response) {
        try {

            JsonObject jsonResponse = JsonParser.parseString(response).getAsJsonObject();

            if (jsonResponse.has("choices") && jsonResponse.getAsJsonArray("choices").size() > 0) {
                JsonObject choice = jsonResponse.getAsJsonArray("choices").get(0).getAsJsonObject();

                if (choice.has("message") && choice.getAsJsonObject("message").has("content")) {
                    return choice.getAsJsonObject("message").get("content").getAsString();
                }
            }

            return "Error: No content found in response";

        } catch (Exception e) {
            logger.error("Error extracting AI response: ", e);
            return "Error: Unable to extract AI response";
        }
    }

}
