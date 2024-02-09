import Inventory.Clue;
import People.*;
import Utility.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import Location.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Location> locations = JsonUtil.parseJsonFile("src/Resources/Locations.json", new TypeReference<List<Location>>() {});
        for (Location i : locations) {
            System.out.println(i.getName());
        }
    }
}