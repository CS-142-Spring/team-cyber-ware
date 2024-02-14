package Interactions;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import People.*;
import Location.*;
import ChatGPT.ChatGPT;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Dialogues {
    private String location;
    private Hero mainHero;
    private Person character;
    private ArrayList<DialogueEntry> dialogueHistory;

    public Dialogues(Hero mainHero, Person character, String location) throws IOException {
        this.mainHero = mainHero;
        this.character = character;
        this.location = location;

        this.dialogueHistory = new ArrayList<>();
    }

    public String processPlayerInput(String input) {
        // this method just process the conversation
        DialogueEntry userEntry = new DialogueEntry(mainHero.getName(), input);
        String prompt = generateChatGPTPrompt(input);
        updateDialogueHistory(userEntry);
        String response = String.valueOf(ChatGPT.chatGPT(prompt));
        DialogueEntry botEntry = new DialogueEntry(character.getName(), response);
        updateDialogueHistory(botEntry);
        return response;
    }

    // the method for adding dialogue entry to the chat history
    private void updateDialogueHistory(DialogueEntry entry) {
        this.dialogueHistory.add(entry);
        //writeHistory(entry);
    }

    private static void writeHistory(DialogueEntry history) {
        //This method will write the chats to the json file
        //we will use this json file to print chats to the console
        try (FileWriter fw = new FileWriter("src/Resources/ChatHistory.json", true)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(fw, history);
            fw.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateChatGPTPrompt(String userInput) {
        StringBuilder promptBuilder = new StringBuilder();

        // adding story description to the prompt
        String story = getStoryDescription();
        promptBuilder.append("Story: ").append(story);

        // describing the hero in the prompt
        promptBuilder.append(" Act as ").append(character.getName()).append(", a ").append(character.getRole())
                .append(" in a text adventure game. You are described as ").append(character.getDescription())
                .append(". Currently, your suspect reason is ").append(character.isSuspect() ? character.getSuspectReason() : "none")
                .append(". Your relationship with the player is ").append(interpretRelationshipWithPlayer())
                .append(", and with the victim, you are ").append(character.getRelationshipWithVictim())
                .append(". Your usefulness is ").append(character.getUsefulness())
                .append(" character. You are currently at ").append(location)
                .append(". Your key traits include ").append(String.join(", ", character.getTraits()))
                .append(". Respond in character to the player's questions and actions and be emotional, maintaining the personality and knowledge consistent with your background and current emotions.")
                .append(". Your response should be concise.");
        // Adding recent chat history
        promptBuilder.append(" Recent conversation history: ");
        int historySize = dialogueHistory.size();
        int contextLimit = 2;

        for (int i = Math.max(0, historySize - contextLimit); i < historySize; i++) {
            DialogueEntry entry = dialogueHistory.get(i);
            promptBuilder.append(entry.getSpeaker()).append(": ")
                    .append(entry.getLine()).append(" ");
        }

        promptBuilder.append("Jack: ").append(userInput);
        return promptBuilder.toString();
    }

    private String interpretRelationshipWithPlayer() {
        // Implement logic to interpret the relationshipWithPlayer numerical value
        // For example:
        if (character.getRelationshipWithPlayer() > 0) {
            return "positive";
        } else if (character.getRelationshipWithPlayer() < 0) {
            return "negative";
        } else {
            return "neutral";
        }
    }

    private String getStoryDescription() {
        // Reads from a file and return string of a description
        ArrayList<String> story = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Hp\\IdeaProjects\\team-cyber-ware\\src\\resources\\storyDescription"));
            String line;
            while((line = reader.readLine()) != null) {
                story.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join(" ", story);
    }

}
