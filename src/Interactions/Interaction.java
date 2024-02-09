package Interactions;

import People.Hero;
import Location.Location;
import People.Person;
import Utility.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Interaction {
    private String playerInput;
    public static void main(String[] args) throws IOException {
        String filePath = "src/Resources/Characters.json";
        List<Person> people = JsonUtil.parseJsonFile(filePath, new TypeReference<List<Person>>() {});
        Hero mainHero = JsonUtil.parseJsonFile("src/Resources/MainHero.json", new TypeReference<Hero>() {});
        Dialogues dialogue = new Dialogues(mainHero, people.get(people.size() - 1), new Location(people.get(people.size() - 1).getCurrentLocation()));

        Scanner console = new Scanner(System.in);
        String line = "";
        while (!line.equals("/exit"))  {
            System.out.print("Jack: ");
            line = console.nextLine();
            String response = dialogue.processPlayerInput(line);
            System.out.println("Rory the Rino");
            System.out.println(response);
        }
    }
}
