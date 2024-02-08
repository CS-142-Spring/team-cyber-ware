package mission;
import java.util.Scanner;
public class PlayTest {

	static String loc = "Location";
	static Scanner scanner = new Scanner(System.in);
		
	
	
	public static void keyWords() {
		System.out.println("Investigate");
		System.out.println("Search");
		System.out.println("Read");
		System.out.println("Move");
		System.out.println("Locations");
		play1();
	}
	
	public static void Locations() {
		
	}
	
	public static void play1() {
		System.out.println("Location: " + loc);
		System.out.print("Action:");
		String action = scanner.nextLine();
		
		if (action.equals("keywords") || action.equals("key words")) {
		    keyWords();
		}
		
		if (action == "Locations") {
			
		}
	}

}
