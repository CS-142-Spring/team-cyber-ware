package Game;

import Inventory.Clue;
import Inventory.Notebook;
import Location.Location;
import People.Hero;
import Utility.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Game {
    public static void resetGameState() {
        try {
            List<Location> locations = JsonUtil.getAllLocations();
            for (Location location : locations) {
                location.setIsExamined(false);
            }
            Hero hero = JsonUtil.getMainHero().get(0);
            hero.setCurrentLocation("Detective's Office");
            System.out.println(hero);
            List<Clue> clues = JsonUtil.getAllClues();
            for (Clue clue : clues) {
                for (Location location : locations) {
                    if (clue.getLocation().equals(location.getName())) {
                        location.setItem(clue);
                    }
                }
            }
            ObjectMapper mapper = new ObjectMapper();

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src\\Resources\\Notebook.json"), new Notebook());

        } catch (IOException e) {
            new RuntimeException(e);
        }
    }
}
