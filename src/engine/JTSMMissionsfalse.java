package engine;
import java.util.Arrays;
public class JTSMMissionsfalse {

	public static void main(String[] args) {
		// the main idea behind the mission class, is the progression of the game.
		// the progression happens based on certain pieces of evidence and puzzles being completed.
		secondStage();
	}

	public static void firstStage() { // will hold the attributes of the first stage
		boolean convo1 = false; //An example variable that is quest related, that is false by default.
        boolean convo2 = false; //Same thing as above, if true, the condition has been met. This will connect to a different class
        boolean stage1 = false; //Same thing as above
		boolean[] conditions = {convo1, convo2}; //array that stores the booleans
		
		boolean allTrue = true; // 
		for (boolean condition : conditions) {
		    if (!condition) { // if not, conditions are not true, this will break the loop because its still false.
		        allTrue = false;
		        break;
		    }
		}
		if (allTrue) { // This checks if 'allTrue' evaluates to true, will print out the appropriate response.
		    System.out.println("All conditions are true"); // This is for testing purposes, remove later.
		    secondStage(); // Just a place holder. This is to push the games progression to stage 2.
					   // I'm unsure if this will work appropriately for actual game play.
		} else {
			System.out.println("All conditions are false"); // This is for testing purposes, remove later.
		}
		
}
	
	public static void secondStage() {
		boolean convo1 = true;
        boolean convo2 = true;
        boolean stage1 = true;
		boolean[] conditions = {convo1, convo2};
		
		boolean allTrue = true;
		for (boolean condition : conditions) {
		    if (!condition) {
		        allTrue = false;
		        break;
		    }
		}
		if (allTrue) {
		    System.out.println("All conditions are true"); // This is for testing purposes, remove later.
		} else {
			System.out.println("All conditions are false"); // This is for testing purposes, remove later.
		}
	}
	
	public static void thirdStage() {
		boolean convo1 = true; //An example variable that is quest related, that is false by default.
        boolean convo2 = true; //Same thing as above 
        boolean stage1 = true; //Same thing as above
		boolean[] conditions = {convo1, convo2};
		
		boolean allTrue = true;
		for (boolean condition : conditions) {
		    if (!condition) {
		        allTrue = false;
		        break;
		    }
		}
		if (allTrue) {
		    System.out.println("All conditions are true"); // This is for testing purposes, remove later.
		} else {
			System.out.println("All conditions are false"); // This is for testing purposes, remove later.
	}
}
		
	public static void fourthStage() {
		boolean convo1 = true; //An example variable that is quest related, that is false by default.
        boolean convo2 = true; //Same thing as above 
        boolean stage1 = true; //Same thing as above
		boolean[] conditions = {convo1, convo2};
		
		boolean allTrue = true;
		for (boolean condition : conditions) {
		    if (!condition) {
		        allTrue = false;
		        break;
		    }
		}
		if (allTrue) {
		    System.out.println("All conditions are true"); // This is for testing purposes, remove later.
		} else {
			System.out.println("All conditions are false"); // This is for testing purposes, remove later.
		}
	}
	
	public static void fifthStage() {
		boolean convo1 = true; // This needs to say 'if stage 4 = true' progress to stage 5
        boolean convo2 = true;
        boolean stage1 = true; 
		boolean[] conditions = {convo1, convo2};
		
		boolean allTrue = true;
		for (boolean condition : conditions) {
		    if (!condition) {
		        allTrue = false;
		        break;
		    }
		}
		if (allTrue) {
		    System.out.println("All conditions are true"); // This is for testing purposes, remove later.
		} else {
			System.out.println("All conditions are false"); // This is for testing purposes, remove later.
		}
	}
}

// Add in the code so each proceeding stage, requires the previous stage to be 'true' to progress.