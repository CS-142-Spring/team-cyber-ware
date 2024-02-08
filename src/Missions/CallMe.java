package mission;

public class CallMe {

	public static void main(String[] args) {
		MissionDetails mssn1 = new MissionDetails();
		MainMenu menu = new MainMenu();
		Story stry = new Story();
		
		menu.main();
		stry.introStory();
//		menu.newGame();
//		mssn1.mission1(); // Calls the method from the missions class. Just for testing purposes. Move somewhere else later.
	}

}