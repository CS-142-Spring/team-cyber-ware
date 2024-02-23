import Inventory.Notebook;
import Utility.JsonUtil;
import Location.Location;
import People.*;
import java.io.IOException;
import java.util.List;

public  class Main {
    public static void main(String[] args) throws IOException {
        List<Location> locations = JsonUtil.getAllLocations();
        System.out.println(locations.get(0).isExamined());
    }
}
