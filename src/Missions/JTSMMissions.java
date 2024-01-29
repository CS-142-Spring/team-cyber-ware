//package mission;
//import java.util.Arrays;
//public class JTSMMissions {
//	
//	// the main idea behind the mission class, is the progression of the game.
//	// the progression happens based on certain pieces of evidence, puzzles, and clues being completed.
//    
//	
//	
//	public static void main(String[] args) {
//		firstStage(); // This is for testing, shows how running this code will work if the conditions are correct.
//	}
//
//	public static void firstStage() {
//	    boolean stageOne = false;
//
//	    while (!stageOne) {
//	        boolean uniqueConvo1 = true; // This should change to true based on some game event or player action.
//	        boolean uniqueConvo2 = true; // This should change to true based on some game event or player action.
//	        // boolean convo3 = false; // Currently unused, consider removing or implementing.
//
//	        boolean[] conditions = {uniqueConvo1, uniqueConvo2};
//	        boolean allTrue = true;
//
//	        for (boolean condition : conditions) {
//	            if (!condition) {
//	                allTrue = false;
//	                break;
//	            }
//	        }
//
//	        if (allTrue) {
//	            stageOne = true;
//	            System.out.println("All conditions are true"); // For testing purposes, remove later.
//	            secondStage(); // Proceed to the next stage.
//	        } else {
//	            System.out.println("All conditions are false1"); // For testing purposes, remove later.
//	        }
//	    }
//	}
//	
//	public static void secondStage() {
//		boolean stageTwo = false;
//		while (!stageTwo) {
//			boolean uniqueItem1 = false; // This will change to true once the item is picked up.
//		    boolean uniqueItem2 = false; // This will change to true once the item is picked up.
//		    boolean item3 = false; // This will change to true once the item is picked up.
//		    boolean uniqueEvidence1 = false; // This will change to true once the item is discovered.
//		    
//		    boolean[] conditions = {uniqueItem1,uniqueItem2,uniqueEvidence1};
//		    boolean allTrue = true; // 
//			for (boolean condition : conditions) {
//			    if (!condition) { // if not, conditions are not true, this will break the loop because its still false.
//			        allTrue = false;
//			        break; //  need to rewrite so it doesn't just break, but also needs it so its not an infinite loop in the background.
//			    }
//			    
//			}
//			if (allTrue) {
//			    System.out.println("All conditions are true"); // This is for testing purposes, remove later.
//			    stageTwo = true;
//			    thirdStage(); // I think this will work. I don't know how well this will work for the game.
//			    // This will pull the game into 'stage 2' now that stage one's conditions have been met.
//			} else {
//				System.out.println("All conditions are false"); // This is for testing purposes, will not be in the game, remove later.
//		}
//	}
//}
//	
//	public static void thirdStage() {
//	    boolean stageThree = false;
//	    while (!stageThree) {
//	        boolean uniqueItem1 = false;
//	        boolean uniqueItem2 = false;
//	        boolean item3 = false;
//	        boolean uniqueEvidence1 = false;
//	        boolean uniqueConvo1 = false;
//	        boolean uniqueConvo2 = false;
//	        boolean convo3 = false; // This conversation is different because it's not unique, thus it doesn't affect the progression of the game.
//
//	        boolean[] conditions = {uniqueItem1,uniqueItem2,item3,uniqueConvo1,uniqueConvo2};
//	        boolean allTrue = true;
//	        for (boolean condition : conditions) {
//	            if (!condition) {
//	                allTrue = false;
//	                break;
//	            }
//	        }
//	        if (allTrue) {
//	            System.out.println("All conditions are true"); // This is for testing purposes, remove later.
//	            stageThree = true;
//			    fourthStage(); // I think this will work. I don't know how well this will work for the game.
//			    // This will pull the game into 'stage 2' now that stage one's conditions have been met.
//	        } else {
//	            System.out.println("All conditions are false"); // This is for testing purposes, will not be in the game, remove later.
//	        }
//	    }
//	}
//	
//	public static void fourthStage() {
//		// Not putting anything here, it would literally just be the same thing
//	}
//	
//	public static void fifthStage() {
//		// Not putting anything here, it would literally just be the same thing.
//		// this class will connect to the story class. maybe rolling the credits, 
//		// or hold the condition allowing the story class to roll the end credits.
//		end.endCredits(); // This is an example of how calling the end credits would work.
//	}
//}
//
//// Add in the code so each proceeding stage, requires the previous stage to be 'true' to progress.