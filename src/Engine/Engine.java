package Engine;

import Location.Location;
import People.*;
import Utility.JsonUtil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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
    public static String currLocation() throws IOException {
        // return the current location of a main hero
        Hero hero = JsonUtil.getMainHero().get(0);
        return (hero.getCurrentLocation());
    }
}

