package Interactions;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import People.*;
import Location.*;
import ChatGPT.ChatGPT;

public class Dialogues {
    private Location location;
    private Hero mainHero;
    private Person character;
    private ArrayList<DialogueEntry> dialogueHistory;
    private ChatGPT gpt;
    public Dialogues(Hero mainHero, Person character, Location location) {
        this.mainHero = mainHero;
        this.character = character;
        this.location = location;
        mainHero.setCurrentLocation(location);
        this.dialogueHistory = new ArrayList<>();
        this.gpt = new ChatGPT();
    }

    // this method just process the conversation
    public String processPlayerInput(String input) {
        DialogueEntry userEntry = new DialogueEntry(mainHero.getName(), input);
        updateDialogueHistory(userEntry);
        String prompt = generateChatGPTPrompt(input);

        String response = gpt.chatGPT(prompt);
        DialogueEntry botEntry = new DialogueEntry(character.getName(), response);
        updateDialogueHistory(botEntry);
        return response;
    }

    // the method for adding dialogue entry to the chat history
    private void updateDialogueHistory(DialogueEntry entry) {
        this.dialogueHistory.add(entry);
        writeHistory(entry);
    }


    //This method will write the chats to the json file
    //we will use this json file to print chats to the console
    private static void writeHistory(DialogueEntry history) {
        try (FileWriter fw = new FileWriter("src/resources/ChatHistory.json", true)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(fw, history);
            fw.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateChatGPTPrompt(String userInput) {
        StringBuilder promptBuilder = new StringBuilder();

        promptBuilder.append("Act as ").append(character.getName()).append(", a ").append(character.getRole())
                .append(" in a text adventure game. You are described as ").append(character.getDescription())
                .append(". Currently, you are ").append(character.isSuspect() ? "a suspect in a mysterious case" : "not a suspect")
                .append(". Your relationship with the player is ").append(interpretRelationshipWithPlayer())
                .append(", and with the victim, you are ").append(character.getRelationshipWithVictim())
                .append(". You are ").append(character.isUseful() ? "a useful and informative" : "an uncooperative")
                .append(" character. You are currently at ").append(location.getName())
                .append(". Your key traits include ").append(String.join(", ", character.getTraits()))
                .append(". Respond in character to the player's questions and actions, maintaining the personality and knowledge consistent with your background and current situation.");

        // Adding recent chat history
        promptBuilder.append(" Recent conversation history: ");
        int historySize = dialogueHistory.size();
        int contextLimit = 2; // Limit to the last 5 exchanges

        for (int i = Math.max(0, historySize - contextLimit); i < historySize; i++) {
            DialogueEntry entry = dialogueHistory.get(i);
            promptBuilder.append(entry.getSpeaker()).append(": ")
                    .append(entry.getLine()).append(" ");
        }
        return promptBuilder.toString();
    }

    private String interpretRelationshipWithPlayer() {
        // Implement logic to interpret the relationshipWithPlayer numerical value
        // For example:
        if (character.getRelationshipWithPlayer() > 10) {
            return "positive";
        } else if (character.getRelationshipWithPlayer() < -10) {
            return "negative";
        } else {
            return "neutral";
        }
    }


}
