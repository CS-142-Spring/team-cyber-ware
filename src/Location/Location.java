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
