package Engine;

import Location.Location;
import People.*;
import Utility.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
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
}

