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
	
	public String describeLocation() {
		return this.description;
	}
	
	public boolean updateAccessibility() {
		return this.accessibility;
	}
	

}
