import Utility.JsonUtil;
import Location.Location;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void PlayerLocation() throws IOException {
        List<Location> locations = JsonUtil.getAllLocations();
        System.out.println(locations.get(2).getName());
    }

    public static void main(String[] args) throws IOException {
        PlayerLocation();
    }
}
