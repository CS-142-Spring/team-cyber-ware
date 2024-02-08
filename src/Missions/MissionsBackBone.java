package mission;

public class MissionsBackBone {

	public static void main(String[] args) {
		
		missionOne();
	}

		
	public static void missionOne() {
	    boolean stageOne = false;

	    while (!stageOne) {
	        boolean uniqueItem1 = false; // This should change to true based on some game event or player action.
	        boolean uniqueItem2 = false; // This should change to true based on some game event or player action.
	        boolean uniqueItem3 = false;
	        // boolean convo3 = false; // Currently unused, consider removing or implementing.

	        boolean[] conditions = {uniqueItem1, uniqueItem2, uniqueItem3};
	        boolean allTrue = true;

	        for (boolean condition : conditions) {
	            if (!condition) {
	                allTrue = false;
	                break;
	            }
	        }

	        if (allTrue) {
	            stageOne = true;
	            System.out.println("All conditions are true"); // For testing purposes, remove later.
	            missionTwo(); // Proceed to the next stage.
	        } else {
	            System.out.println("All conditions are false1"); // For testing purposes, remove later.
	            // Implement game logic here to allow conditions to change based on player actions.
	        }
	    }
	}
	
	public static void missionTwo() {
		boolean stageTwo = false;
		while (!stageTwo) {
			boolean uniqueItem1 = false; // This will change to true once the item is picked up.
		    boolean uniqueItem2 = false; // This will change to true once the item is picked up.
		    boolean item3 = false; // This will change to true once the item is picked up.
		    boolean uniqueEvidence1 = false; // This will change to true once the item is discovered.
		    
		    boolean[] conditions = {uniqueItem1,uniqueItem2,uniqueEvidence1};
		    boolean allTrue = true; // 
			for (boolean condition : conditions) {
			    if (!condition) { // if not, conditions are not true, this will break the loop because its still false.
			        allTrue = false;
			        break; //  need to rewrite so it doesn't just break, but also needs it so its not an infinite loop in the background.
			    }
			    
			}
			if (allTrue) {
			    stageTwo = true;
			    System.out.println("All conditions are true2");
			    // missionThree(); // Call the next stage here if needed.
			} else {
			    System.out.println("All conditions are false2");
			}
	}
}
	
	public static void missionThree() {
	    boolean stageThree = false;
	    while (!stageThree) {
	        boolean uniqueItem1 = false;
	        boolean uniqueItem2 = false;
	        boolean item3 = false;
	        boolean uniqueEvidence1 = false;
	        boolean uniqueConvo1 = false;
	        boolean uniqueConvo2 = false;
	        boolean convo3 = false; // This conversation is different because it's not unique, thus it doesn't affect the progression of the game.

	        boolean[] conditions = {uniqueItem1,uniqueItem2,uniqueConvo1,uniqueConvo2};
	        boolean allTrue = true;
	        for (boolean condition : conditions) {
	            if (!condition) {
	                allTrue = false;
	                break;
	            }
	        }
	        if (allTrue) {
	            System.out.println("All conditions are true"); // This is for testing purposes, remove later.
	            stageThree = true;
			    missionFour(); // I think this will work. I don't know how well this will work for the game.
			    // This will pull the game into 'stage 2' now that stage one's conditions have been met.
	        } else {
	            System.out.println("All conditions are false3"); // This is for testing purposes, will not be in the game, remove later.
	        }
	    }
	}
	
	public static void missionFour() {
		// Not putting anything here, it would literally just be the same thing
	}
	
	public static void missionFive() {
		// Not putting anything here, it would literally just be the same thing.
		// this class will connect to the story class. maybe rolling the credits, 
		// or hold the condition allowing the story class to roll the end credits.
	}
}