package Engine;

import Location.Location;
import People.Hero;
import People.Person;
import Utility.JsonUtil;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Engine {

    public static void move(int index, JFrame frame) throws IOException {
        Hero hero = JsonUtil.getMainHero().get(0);
        List<Location> locations = JsonUtil.getAllLocations();
        if (index < locations.size() - 1 && index >= 0) {
            hero.setCurrentLocation(locations.get(index).getName());
            System.out.println(hero.getCurrentLocation());
        }
    }
}
