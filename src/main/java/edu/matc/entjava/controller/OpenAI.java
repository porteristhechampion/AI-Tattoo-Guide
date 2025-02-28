package edu.matc.entjava.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenAI {

    private static final String API_KEY = System.getenv("OPENAI_API_KEY");
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String MODEL = "gpt-3.5-turbo";

    private static final Logger logger = LogManager.getLogger(OpenAI.class);

    public static void main(String[] args) {

        logger.info(getAIResponse("Give me a cool tattoo idea"));
        System.out.println(System.getenv("OPENAI_API_KEY"));

    }

    public static String getAIResponse(String message) {

        try {
            URL urlObj = new URL(API_URL);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + API_KEY);
            con.setRequestProperty("Content-Type", "application/json");

            String body = "{\"model\": \"" + MODEL + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";
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

//            logger.info(response.toString());

            return extractAIResponse(response.toString());

        } catch (IOException ioException) {
            logger.error(ioException);

            return "Error: Unable to get AI response";
        }
    }

    public static String extractAIResponse(String response) {
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
