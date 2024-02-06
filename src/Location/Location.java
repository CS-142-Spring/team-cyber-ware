package Location;
import Inventory.Clue;
import People.Person;
import java.util.ArrayList;
import java.util.List;

public class Location {
	String name;
	String description;
	List<Clue> items;
	List<Person> people;
	boolean accessibility;

	public Location() {}

	public Location(String name) {
		this.name = name;
		this.description = "Unknown";
	}

	public Location(String name,
					String description,
					boolean accessibility,
					ArrayList<Clue> items,
					ArrayList<Person> people) {
		this.name = name;
		this.description  = description;
		this.accessibility = accessibility;
		this.items = items;
		this.people = people;
	}
	
	public String describeLocation() {
		return this.description;
	}

	public List<Clue> getItems() {
		return this.items;
	}

	public List<Person> getPeople() {
		return this.people;
	}

	public boolean getAccessibility() {
		return this.accessibility;
	}
	public void setAccessibility(boolean choice){
		this.accessibility = choice;
	}
	public String getName(){
		return this.name;
	}
	

}
