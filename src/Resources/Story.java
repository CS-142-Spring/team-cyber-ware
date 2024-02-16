package Missions; // I would like to make it so story parts have a being typed out effect.
public class Story { // Holds the 5 parts of the story that help clue the player into what's happening.
	public void storyHelp() {
		StringBuilder str = new StringBuilder();
		str.append("Hello! Before you begin on finding Coach Marlowe. How about learning how to navigate through the game.")
		.append("Your movement and interactions comprise of mostly keywords. Here they are:");

	}
	
	public static void segmentStory() {
	    System.out.println("\nDetective Malone takes another case. Using the limited information from Richard Miles, he"
	            + " sets out to \n" + "investigate Coach Marlowe's disappearance. " + "Starting with Coach Marlowes office...");
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
