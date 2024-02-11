import People.*;
import Utility.JsonUtil;
import Location.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> people = JsonUtil.getAllPeople();
        for (Person i : people) {
            System.out.println(i.getName());
        }
    }
}