package Utility;

import Inventory.Clue;
import Location.Location;
import People.Hero;
import People.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static <T> T parseJsonFile(String filePath, TypeReference<T> typeReference) throws IOException {
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return objectMapper.readValue(new File(filePath), typeReference);
    }

    public static List<Person> getAllPeople() throws IOException {
        return parseJsonFile("src\\Resources\\Characters.json", new TypeReference<List<Person>>() {
        });
    }

    public static List<Location> getAllLocations() throws IOException {
        return parseJsonFile("src\\Resources\\Locations.json", new TypeReference<List<Location>>() {
        });
    }

    public static List<Hero> getMainHero() throws IOException {
        return parseJsonFile("src\\Resources\\MainHero.json", new TypeReference<List<Hero>>() {
        });
    }

    public static List<Clue> getAllClues() throws IOException {
        return parseJsonFile("src\\Resources\\Clue.json", new TypeReference<List<Clue>>() {
        });
    }

    public static void update(List<Person> people) {
        try {
            File jsonFile = new File("src\\Resources\\Characters.json"); // Update with the path to your JSON file

            // Write the updated list back to the file
            objectMapper.writeValue(jsonFile, people);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
