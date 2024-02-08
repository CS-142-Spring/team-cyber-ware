package mission;
import java.util.Scanner;
public class Missions {
}

class MissionDetails {
    private String title;
    private String Objective;
    private String[] clues;
    private String[] evidence;
    private String directions;
    private String location;
    static Scanner scanner = new Scanner(System.in);
    static Story story = new Story();
    
    // Getter and setter for title
    
    public String getTitle() {
    	
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter for Objective
    public String getObjective() {
        return Objective;
    }

    public void setObjective(String Objective) {
        this.Objective = Objective;
    }

    // Getter and setter for clues
    public String[] getClues() {
        return clues;
    }

    public void setClues(String[] clues) {
        this.clues = clues;
    }

    // Getter and setter for evidence
    public String[] getEvidence() {
        return evidence;
    }

    public void setEvidence(String[] evidence) {
        this.evidence = evidence;
    }
    
    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
    
    public String getLocation() {
    	
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public static void keyWordsHelp() {
		System.out.println("\n1. Investigate" + "\n2. Search" + "\n3. Read" + "\n4. Move" + "\n5. Locations\n");
		System.out.println("Search - Used for searching rooms, lockers, containers, etc. - used to discover items. This will also \n"
				+ "	 add items  to your inventory.");
		System.out.println("Investigate - Used to investigate items that were found by using the search keyword.");
		System.out.println("Read - Used for reading books, sticky notes, notes, etc.- used to find clues. This keyword also\n"
				+ "saves certain things you've learned to your notebook.");
		System.out.println("Move - Used for switching rooms, you know where you can move based on the available directions at "
				+ "\n       the bottom of the screen.");
		System.out.println("Locations - Used for moving to other known locations.");
		System.out.println("\nThat's all for now, good luck Detective Malone");
		continueMethod();
 }
	public static void continueMethod() {
		System.out.print("Type enter to continue:");
		String answer = scanner.nextLine(); // Instead this should be a button.
	    if (answer.equalsIgnoreCase("'Enter'")) {
				story.segmentStory();
			} else {
				System.out.println("That is not a valid input");
				continueMethod();
			}
	}
    
    public static void keyWords() {
		System.out.println("Investigate");
		System.out.println("Search");
		System.out.println("Read");
		System.out.println("Move");
		System.out.println("Locations");
	}
    
    public static void mission1() {
        MissionDetails mission = new MissionDetails();
        mission.setLocation("Jack Malones Office");
        mission.setTitle("Mission: " + "Good things come to those who work!");
        mission.setObjective("\nFollow up on the leads provided by the 'initial caller'.");
        mission.setDirections("Straight"); // Meant to be at bottom of screen, displayed or titled some how.
//        mission.setClues(new String[]{"Mysterious footprint", "Broken display case"});
//        mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage", "Size 14 shoes"});
        System.out.println("Location: " + mission.getLocation());
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Clues: " + String.join(", ", mission.getClues()));
        System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
        System.out.println("Directions: " + mission.getDirections());
        System.out.println("Input an action: ");
        String choice = scanner.nextLine();
        	
        if (choice == "Search" ) {
        		
        	}else if (choice == "Read") {
        		
        	}else if (choice == "Move") {
        		
        	}else if (choice == "Locations") {
        		
        	}
    }
    
    public static void mission2() {
        MissionDetails mission = new MissionDetails();
        mission.setTitle("Mission: " + "Good things come to those who work!");
        mission.setObjective("Follow up on the leads provided by the 'initial caller'.");
        mission.setDirections("Straight");
        mission.setClues(new String[]{"Mysterious footprint", "Broken display case"});
        mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage", "Size 14 shoes"});
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Clues: " + String.join(", ", mission.getClues()));
        System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
        System.out.println("Directions: " + mission.getDirections());
    }
    
    public static void mission3() {
    	
    	MissionDetails mission = new MissionDetails();
    	mission.setTitle("Every day is an opportunity disguised as a challenge"); // Quote by Tiki Barber
    	mission.setObjective(""); // Continue off of the story plot point given here.
    	mission.setDirections("");
    	mission.setClues(new String[]{"Mysterious footprint", "Broken display case"}); // clues in this phase to be discovered.
    	mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"}); // Evidence to be discovered.
    	System.out.println("Mission Title: " + mission.getTitle());
    	System.out.println("Mission Objective: " + mission.getObjective());
    	System.out.println("Clues: " + String.join(", ", mission.getClues()));
    	System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
    	System.out.println("Directions: " + mission.getDirections());
    }
    
    public static void mission4() {
    	
    	MissionDetails mission = new MissionDetails();
    	mission.setTitle("You cannot make progress with excuses"); // Quote by Cam Newton
    	mission.setObjective(""); // Continue off of the story plot point given here.
    	mission.setDirections("");
    	mission.setClues(new String[]{"Mysterious footprint", "Broken display case"}); // clues in this phase to be discovered.
    	mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"}); // Evidence to be discovered.
    	System.out.println("Mission Title: " + mission.getTitle());
    	System.out.println("Mission Objective: " + mission.getObjective());
    	System.out.println("Clues: " + String.join(", ", mission.getClues()));
    	System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
    	System.out.println("Directions: " + mission.getDirections());
    }
    
    public static void mission5() {
    	
    	MissionDetails mission = new MissionDetails();
    	mission.setTitle("No one ever drowned in sweat"); // Quote by Lou Holtz
    	mission.setObjective(""); // Continue off of the story plot point given here.
    	mission.setDirections("");
    	mission.setClues(new String[]{"Mysterious footprint", "Broken display case"}); // clues in this phase to be discovered.
    	mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"}); // Evidence to be discovered.
    	System.out.println("Mission Title: " + mission.getTitle());
    	System.out.println("Mission Objective: " + mission.getObjective());
    	System.out.println("Clues: " + String.join(", ", mission.getClues()));
    	System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
    	System.out.println("Directions: " + mission.getDirections());
    }
    
    public static void mission6() {
    	
    	MissionDetails mission = new MissionDetails();
    	mission.setTitle("When you don’t give up, you cannot fail"); // Quote by Adrian Peterson
    	mission.setObjective("Follow up on the leads provided by"); // the leads given by whoever initially called.
    	mission.setDirections("");
    	mission.setClues(new String[]{"Mysterious footprint", "Broken display case"}); // whatever clues that can be found at the starting locations
    	mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"});
    	System.out.println("Mission Title: " + mission.getTitle());
    	System.out.println("Mission Objective: " + mission.getObjective());
    	System.out.println("Clues: " + String.join(", ", mission.getClues()));
    	System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
    	System.out.println("Directions: " + mission.getDirections());
    }
    
    public static void main(String[] args) {
        MissionDetails mission = new MissionDetails();
        mission.setTitle("The Missing Artifact");
        mission.setObjective("Investigate the disappearance of a valuable artifact from the museum.");
        mission.setClues(new String[]{"Mysterious footprint", "Broken display case"});
        mission.setEvidence(new String[]{"Fingerprint analysis report", "Security camera footage"});
        System.out.println("Mission Title: " + mission.getTitle());
        System.out.println("Mission Objective: " + mission.getObjective());
        System.out.println("Clues: " + String.join(", ", mission.getClues()));
        System.out.println("Evidence: " + String.join(", ", mission.getEvidence()));
        System.out.println("Directions: " + mission.getDirections());
    }
}