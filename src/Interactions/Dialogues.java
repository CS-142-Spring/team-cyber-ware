package Interactions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialogues {
    // Under Testing. Don't touch!!
    public static void main(String[] args) {
        ArrayList<DialogueEntry> dialogueHistory = new ArrayList<>();

        Scanner console = new Scanner(System.in);
        String line = "";
        while (!line.equals("/exit")) {
            System.out.print("Jack: ");
            line = console.nextLine();
            DialogueEntry userEntry = new DialogueEntry("Jack", line);
            writeHistory(userEntry);
            dialogueHistory.add(userEntry);
            if (!line.equals("/exit")) {
                String response = chatGPT(line);
                System.out.println("Bot: " + response);
                DialogueEntry botEntry = new DialogueEntry("Bot", response);
                writeHistory(botEntry);
                dialogueHistory.add(botEntry);
            }

        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(dialogueHistory);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static String chatGPT(String message) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = ""; // API key goes here
        String model = "gpt-4-0125-preview"; // current model of chatgpt api

        try {
            // Create the HTTP POST request
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // Build the request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";
            con.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // returns the extracted contents of the response.
            return extractContentFromResponse(response.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // This method extracts the response expected from chatgpt and returns it.
    public static String extractContentFromResponse(String response) {
        System.out.println(response);
        int startMarker = response.indexOf("content") + 11; // Marker for where the content starts.
        int endMarker = response.indexOf("\"", startMarker); // Marker for where the content ends.
        return response.substring(startMarker, endMarker); // Returns the substring containing only the response.
    }
    //This method will write the chats to the json file
    //we will use this json file to print chats to the console
    public static void writeHistory(DialogueEntry history) {
        try (FileWriter fw = new FileWriter("src/resources/ChatHistory.json", true)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(fw, history);
            fw.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
