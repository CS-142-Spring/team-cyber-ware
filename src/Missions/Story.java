package mission; // I would like to make it so story parts have a being typed out effect.
import java.util.Scanner;
public class Story { // Holds the 5 parts of the story that help clue the player into what's happening. 
	
	static MissionDetails mssn = new MissionDetails(); // Found in Missions class.
	static PlayTest pt = new PlayTest();
	static Scanner scanner = new Scanner(System.in);
	
	public static void introStory() { // pushes out the introduction of the game.
		System.out.println("\nGridiron City. " + "A light rain taps rhythmically against the window of a gritty downtown office." 
	+ "\n" + "Upon further inspection, this is the office of Detective Jack 'The Shadow' Malone. Malone," + "\n" + "is a seasoned investigator " 
				+ "known for solving complex cases. Although, Malone doesn't actually work \nfor the GPD anymore, they refuse to fire him officially, "
				+ "leaving his office intact, and he never "
				+ "\nofficially quit. So he's a detective forever in limbo.");
		System.out.println("\n" + "While sitting at his desk, surrounded by scattered files, and a flickering lamp. The phone" + "\n" + 
				"on his desk, suddenly begins to ring." + "\n");
							// Italicize Richard Miles from Gridiron Sports Commission.
		System.out.println("Upon picking up the phone, Richard Miles speaks in a panic.\n");
		System.out.println("Richard: Hello, is this Detective " + "Jack Malone?"
				+ " This is Richard Miles from" + "\nGridiron Sports Commission. Listen, we need your help it's dire. " + "We've looked all over" + 
				"\nand still can't find Coach Marlowe!");
		System.out.println("\nJack remains silent for a moment.");
		System.out.println("\nJack: You sure Marlowe isn't staying out of the publics eye to calm his nerves?");
		System.out.println("\nRichard: I'm sure of it! He's 30 years in the making and is sure to go down as the greatest" + "\nCoach of all time "
				+ "after this upcoming game!" + " For him to "
				+ "have nerves now is silly.");
		System.out.println("\nRichard: Now look, after talking with his wife Evelyn and Vice Coach Brown we found somethings\nbut it aint much. Evelyn "
				+ "said that he never came home yesterday. " + "Which is odd according to \nEvelyn, she said he's a man of routine, never changes or deviates "
				+ "for anything. Vice Coach Brown \nsaid he last saw him during the late-night meeting. " + "After the meeting, Coach Marlowe told Brown "
				+ "\nhe was going to his office to grab something before heading home. That being the last time Brown \nsaw him.");
		System.out.println("\nRichard: So what do you say Detective Malone? Will you help Marlowes family, his team, the \ncommission and the entire league by finding "
				+ "him?");
		System.out.println("\nJack: Let me think about it.");
		System.out.println("\nThe phone *clicks*");
				// The below text needs to be italicized.
		System.out.println("Vincent 'Victory' Marlowe missing three days before the biggest game of the century. If that doesn't "
				+ "\nseem off I don't what does. His team, " + "the GridIron Gladiators whose current record is 19-0. The talk "
						+ "\nof the town is they're about to play against Trumbledale Titans, who are also 19-0 in their respective \n"
						+ "divisions.");
		System.out.println("\nLooks like I've just been handed a full plate, it's time to get to work.");
		 		// The text above are Jacks thoughts, they need to be italicized to convey that it's his thoughts.
		// Needs to be able to hit enter to continue
		System.out.print("To continue enter Y: ");
		String answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("y")) {
				storyHelp();
			} else {
				System.out.println("That is an invalid input");
				
			}
	}
	
	public static void storyHelp() {
		System.out.println("\nHello! Before you begin on finding Coach Marlowe. How about learning how to navigate through the game.");
		System.out.println("Your movement and interactions comprise of mostly keywords. Here they are:");
		mssn.keyWordsHelp();
	}
	
	public static void segmentStory() {
	    System.out.println("\nDetective Malone takes another case. Using the limited information from Richard Miles, he"
	            + " sets out to \n" + "investigate Coach Marlowe's disappearance. " + "Starting with Coach Marlowes office...");
	    mssn.mission1();
//	    midStory();
	}
	
	public static void midStory() {
	    System.out.println("\nAs Jack digs deeper into the investigation, he uncovers a web of secrets and rivalries within the GridIron Gladiators."
	            + " Suspicion looms over star players, disgruntled staff members, and even rival coaches from other teams.");
	    System.out.println("\nFollowing the cryptic message, Jack discovers a hidden underground world of illegal sports betting and game-fixing."
	            + " Marlowe was onto something big, and his disappearance might be connected to the corruption threatening the integrity of the league.");
	    System.out.println("\nWith the championship game drawing nearer, Jack races against time to unravel the truth behind Marlowe's vanishing act."
	            + " The city is buzzing with anticipation for the historic clash, unaware of the darker game being played behind the scenes.");
	    segmentStory2();
	}
	
	public static void segmentStory2() {
	    System.out.println("\nAs Jack pieces together the puzzle, he confronts the culprits behind Marlowe's disappearance and the league's corruption."
	            + " A tense showdown ensues, revealing a complex conspiracy involving powerful individuals who sought to manipulate the outcome of the game.");
	    System.out.println("\nIn a dramatic turn of events, Jack manages to rescue Marlowe just in time for the championship game. The truth comes to light,"
	            + " restoring justice to Gridiron City and preserving the integrity of the sport.");
	    System.out.println("\nThe championship game unfolds with an electric atmosphere, but this time, it's not just about the victory on the field."
	            + " GridIron Gladiators triumph not only as champions but as symbols of resilience against corruption.");
	    finalStory();
	}
	
	    public static void finalStory() {
	        System.out.println("\nWith the case closed and justice served, Jack Malone returns to his office. The rain outside has ceased,"
	                + " and a faint glimmer of sunlight breaks through the clouds.");
	        System.out.println("\nRichard Miles expresses his gratitude, and Coach Marlowe thanks Jack for saving both his life and the integrity of the game."
	                + " The city hails Malone as a hero, but true to his nature, he slips back into the shadows, ready for the next mystery that may come his way.");
	        System.out.println("\nGridiron City is safe, the championship was played on a fair field, and Detective Jack 'The Shadow' Malone remains an enigma"
	                + " in the heart of the city's intricate tales.");
	    }
}
