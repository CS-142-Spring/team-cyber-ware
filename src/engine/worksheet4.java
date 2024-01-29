package engine;

public class worksheet4 {

	public static void main(String[] args) {
	}
	
	public static void firstStage() {
		boolean stageOne = false;
		
		while (!stageOne) {
			boolean uniqueConvo1 = true; // This is will change to true, if the conversation is had, lifting the restriction.
		    boolean uniqueConvo2 = true; // This is will change to true, if the conversation is had, lifting the restriction.
		    boolean convo3 = false; // This conversation is different because it's not unique,
		    										// meaning it doesn't prevent the story from progressing.
		    boolean[] conditions = {uniqueConvo1, uniqueConvo2,};
		    boolean allTrue = true; // 
			for (boolean condition : conditions) {
			    if (!condition) { // if not, conditions are not true, this will break the loop because its still false.
			        allTrue = false;
			        break; //  need to rewrite so it doesn't just break, but also needs it so its not an infinite loop in the background.
			    }
			    
			}
			if (allTrue) {
				stageOne = true;
			    System.out.println("All conditions are true"); // This is for testing purposes, remove later.
			     // I think this will work. I don't know how well this will work for the game.
			    // This will pull the game into 'stage 2' now that stage one's conditions have been met.
			} else {
				System.out.println("All conditions are false"); // This is for testing purposes, remove later.
		}
	}
}
}
