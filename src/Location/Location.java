package Location;
import Inventory.Clue;
import People.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.List;


// the class for location object
public class Location {
	private String name;
	private String description;
	private List<Clue> items;
	private List<Person> people;
	private boolean accessibility;
	private boolean isExamined;

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

	public boolean isExamined() {
		return this.isExamined;
	}

	public void setIsExamined(boolean bool) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		File heroFile = new File("src\\Resources\\MainHero.json");
		ObjectNode heroNode = (ObjectNode) objectMapper.readTree(heroFile);

		heroNode.put("isExamined", bool);
		this.isExamined = bool;
		// Write the updated JSON back to the file
		objectMapper.writeValue(heroFile, heroNode);
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
