package Location;
import java.util.ArrayList;

public class Location {
	String name;
	String description;
	ArrayList<String> items;
	ArrayList<String> people;
	boolean accessibility;
	
	public Location(String name, String description, boolean accessibility) {
		this.name = name;
		this.description  = description;
		this.accessibility = accessibility;
		this.items = new ArrayList<>();
		this.people = new ArrayList<>();
	}
	
	public describeLocation() {
		return this.description;
	}
	
	public updateAccessibility() {
		return this.accessibility;
	}
	

}
