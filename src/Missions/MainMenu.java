package Missions;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
public class MainMenu {
	static Scanner scanner = new Scanner(System.in);
	static final String SAVE_DIRECTORY = "C:/Games/Saves/JTSMB";
	
	public static void main() {
		System.out.println("1. New Game" + "\n" + "2. resume" + "\n" + "3. options" + "\n" + "4. quit");
		System.out.print("Choice: ");
		int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                newGame();
                break;
            case 2:
//                resume();
            	System.out.print("This is disabled for now");
            	main();
                break;
            case 3:
                options();
                break;
            case 4:
                quit();
                break;
            default:
                System.out.println("An incorrect input was made");
                main(); // Restart the main method
        }
	}
	
	public static void newGame() {
        System.out.println("Please enter your name");
        System.out.println("Note that this name will serve as the file save name");
        System.out.print("Save name: ");
        String saveName = scanner.next();

        try {
            File saveFile = new File(SAVE_DIRECTORY + saveName + ".txt");
            saveFile.getParentFile().mkdirs(); // Create directories if they don't exist
            saveFile.createNewFile(); // Create the save file
            FileWriter writer = new FileWriter(saveFile);
            writer.write("Game data goes here...");
            writer.close();
            System.out.println("Your file has been saved as " + saveName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the game.");
        }
    }
	
//	public static void resume() {
//        File saveFolder = new File(SAVE_DIRECTORY);
//        File[] savedGames = saveFolder.listFiles();
//
//        if (savedGames != null && savedGames.length > 0) {
//            System.out.println("Saved games:");
//            Arrays.sort(savedGames);
//            for (int i = 0; i < savedGames.length; i++) {
//                System.out.println((i + 1) + ". " + savedGames[i].getName());
//            }
//
//            System.out.print("Enter the number of the game to load: ");
//            int choice = scanner.nextInt();
//
//            if (choice > 0 && choice <= savedGames.length) {
//                loadGame(savedGames[choice - 1]);
//            } else {
//                System.out.println("Invalid choice");
//            }
//        } else {
//            System.out.println("No saved games found");
//        }
//    }
	
	public static void options() {
		// player should be able to load their game settings to change font size, maybe color for the color blind folks, etc.
		System.out.println("Options have been optioned");
	}
	
	public static void quit() {
		// The program should quit based on if the player hits number 4 or types quit.
		System.out.println("Quitting the program");
		System.exit(0);
	}


}