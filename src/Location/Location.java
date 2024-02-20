package Location;
import Inventory.Clue;
import People.Person;

import java.util.List;


// the class for location object
public class Location {
	private String name;
	private String description;
	private List<Clue> items;
	private List<Person> people;
	private boolean accessibility;

	public Location() {}

	public Location(String name) {
		this.name = name;
	}

	public Location(String name,
					String description,
					List<Clue> items,
					List<Person> people,
					boolean accessibility) {
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

	public String getDescription() {
		return this.description;
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
