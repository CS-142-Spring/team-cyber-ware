package Engine;

import Location.Location;
import People.*;
import Utility.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    public static void move(int index, JTextArea textArea) throws IOException {
        // changes the location of the main hero
        Hero hero = JsonUtil.getMainHero().get(0);
        List<Location> locations = JsonUtil.getAllLocations();
        if (index < locations.size() && index >= 0) {
            System.out.println(index);
            hero.setCurrentLocation(locations.get(index).getName());
            textArea.setText("You are in " + locations.get(index).getName());
        }
    }

    public static ArrayList<String> interact(JPanel gamePlayPanel) {
        // Specify the path to your JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<String> items = new ArrayList<>();
        File file = new File("src/Resources/Locations.json");
        String Location = null;
        try {
            Location = Engine.currLocation();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        JsonNode foundLocation = null;
        if (jsonNode.isArray()) {
            for (JsonNode location : jsonNode) {
                if (location.get("isExamined").asBoolean() && location.get("name").asText().equals(Location)) {
                    foundLocation = location;
                    break;
                } else if (!location.get("isExamined").asBoolean() && location.get("name").asText().equals(Location)) {
                    JOptionPane.showMessageDialog(gamePlayPanel, "You need to search the room first", "Warning", JOptionPane.WARNING_MESSAGE);
                    return null;
                }

            }
        }

        JsonNode itemsNode = foundLocation.get("items");
        for (JsonNode item : itemsNode) {
            items.add(item.get("name").asText());
        }

        return items;
    }

    public static ArrayList<String> getPeople() throws IOException {
        ArrayList<String> peopleNames = new ArrayList<>();
        List<Location> locations = JsonUtil.getAllLocations();
        for (Location location : locations) {
            if (location.getName().equals(currLocation())) {
                for (Person person : location.getPeople()) {
                    peopleNames.add(person.getName());
                }
            }

        }
        return peopleNames;
    }

    public static String currLocation() throws IOException {
        // return the current location of a main hero
        Hero hero = JsonUtil.getMainHero().get(0);
        return (hero.getCurrentLocation());
    }

    public static void addItems(String item){
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Specify the file location
            File jsonFile = new File("src/Resources/Notebook.json");

            // Parse your JSON file
            ObjectNode rootNode = (ObjectNode) mapper.readTree(jsonFile);

            // Get the "clues" array
            ArrayNode cluesNode = (ArrayNode) rootNode.get("clues");

            // Add items to the "clues" array
            cluesNode.add(item);

            // Write the updated rootNode back to the file
            mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void removeItems(String itemToRemove) throws IOException {
        // Read the JSON file
        String content = new String(Files.readAllBytes(Paths.get("src/Resources/Locations.json")));

        // Create an ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Read the JSON content into a JsonNode
        ArrayNode jsonNode = (ArrayNode) mapper.readTree(content);

        // Iterate over the array
        for (int j = 0; j < jsonNode.size(); j++) {
            // Get the "items" array from the object
            ArrayNode items = (ArrayNode) jsonNode.get(j).get("items");

            int index = -1;
            // Find the index of the item to remove
            for (int i = 0; i < items.size(); i++) {
                String item = items.get(i).asText();
                if (item.equals(itemToRemove)) {
                    index = i;
                    break;
                }
            }
            // Remove the item if it was found
            if (index != -1) {
                // This creates a new ArrayNode without the item
                ArrayNode newArray = mapper.createArrayNode();
                for (int i = 0; i < items.size(); i++) {
                    if (i != index) {
                        newArray.add(items.get(i));

                    }
                }

                // Replace the old array with the new one
                ((ObjectNode) jsonNode.get(j)).set("items", newArray);
            }
        }

        // Convert the JsonNode back to a string
        String updatedContent = mapper.writeValueAsString(jsonNode);

        // Write the updated JSON string back to the file
        Files.write(Paths.get("src/Resources/Locations.json"), updatedContent.getBytes());
    }
}

