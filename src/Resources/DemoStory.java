package Resources;

import static Resources.Story.scanner;
import static Missions.MissionDetails.mission1;

public class DemoStory { // this class was whipped up with already created code and ideas in mind, but crafted
                         // specifically with the perspective of a game demo in mind.

    public static void main(String[] args){

    }

    public static void demoIntro() { // pushes out the introduction of the game.
        System.out.println("""

                Gridiron City. A light rain taps rhythmically against the window of a gritty downtown office.
                Upon further inspection, this is the office of Detective Jack 'The Shadow' Malone. Malone,
                is a seasoned investigator known for solving complex cases. Although, Malone doesn't actually work\s
                for the GPD anymore, they refuse to fire him officially, leaving his office intact, and he never\s
                officially quit. So he's a detective forever in limbo.""");
        System.out.println("""

                While sitting at his desk, surrounded by scattered files, and a flickering lamp. The phone
                on his desk, suddenly begins to ring.
                """);
        // Italicize the name Richard Miles from Gridiron Sports Commission. Build a better narrative
        System.out.println("Upon picking up the phone, Richard Miles speaks in a panic.\n");
        System.out.println("""
                Richard: Hello, is this Detective Jack Malone? This is Richard Miles from
                Gridiron Sports Commission. Listen, we need your help it's dire. We've looked all over
                and still can't find Coach Marlowe!""");
        System.out.println("\nJack remains silent for a moment.");
        System.out.println("\nJack: You sure Marlowe isn't staying out of the publics eye to calm his nerves?");
        System.out.println("""

                Richard: I'm sure of it! He's 30 years in the making and is sure to go down as the greatest
                Coach of all time after this upcoming game! For him to have nerves now is silly.""");
        System.out.println("""

                Richard: Now look, after talking with his wife Evelyn and Vice Coach Brown we found somethings
                but it aint much. Evelyn said that he never came home yesterday. Which is odd according to\s
                Evelyn, she said he's a man of routine, never changes or deviates for anything. Vice Coach Brown\s
                said he last saw him during the late-night meeting. After the meeting, Coach Marlowe told Brown\s
                he was going to his office to grab something before heading home. That being the last time Brown\s
                saw him.""");
        System.out.println("""

                Richard: So what do you say Detective Malone? Will you help Marlowes family, his team, the\s
                commission and the entire league by finding him?""");
        System.out.println("\nJack: Let me think about it.");
        System.out.println("\nThe phone *clicks*");
        // The below text needs to be italicized. It signifies the detectives thoughts. Builds the narrative
        System.out.println("""
                Vincent 'Victory' Marlowe missing three days before the biggest game of the century. If that doesn't\s
                seem off I don't what does. His team, the GridIron Gladiators whose current record is 19-0. The talk\s
                of the town is they're about to play against Trumbledale Titans, who are also 19-0 in their respective\s
                divisions.""");
        System.out.println("\nLooks like I've just been handed a full plate, it's time to get to work.");
        storyHelp(); // Plays storyHelp which teaches how to play the game.
    }

    public static void storyHelp() {
        System.out.println("\nHello! Before you begin on finding Coach Marlowe. How about learning how to navigate through the game.");
        System.out.println("Your movement and interactions comprise of mostly keywords. Here they are:");
        keyWords(); // Lists the keywords for the player.
        keyWordsHelp(); // Defines what each keyword does.
    }

    public static void keyWords() { // Prints out the keywords in a list
        System.out.println("Investigate");
        System.out.println("Search");
        System.out.println("Read");
        System.out.println("Move");
        System.out.println("Locations");
    }

    public static void keyWordsHelp() {
        System.out.println("""

                1. Investigate
                2. Search
                3. Read
                4. Move
                5. Locations
                """);
        System.out.println("Search - Used for searching rooms, lockers, containers, etc. - used to discover items. This will also \n"
                + "	 add items  to your inventory.");
        System.out.println("Investigate - Used to investigate items that were found by using the search keyword.");
        System.out.println("Read - Used for reading books, sticky notes, notes, etc.- used to find clues. This keyword also\n"
                + "saves certain things you've learned to your notebook.");
        System.out.println("Move - Used for switching rooms, you know where you can move based on the available directions at "
                + "\n       the bottom of the screen.");
        System.out.println("Locations - Used for moving to other known locations.");
        System.out.println("\nThat's all for now, good luck Detective Malone");
        continueMethod(); // provides the players a way to take a break to read everything before continuing into
        // gameplay
    }

    public static void continueMethod() { // used to allow the player a break instead of being thrust into the game.
        System.out.print("Type enter to continue:");
        String answer = scanner.nextLine(); // Instead this should be a button.
        if (answer.equalsIgnoreCase("Enter")) {
            mission1();
        } else {
            System.out.println("That is not a valid input");
            continueMethod(); // Will rerun if the player makes an invalid input.
        }
    }

    public static void demoEnd() { // Finishes out the demo of the game.
        System.out.println("Good job on getting into Coach Marlowe's computer and discovering that someones been " +
                "threatening him. Unfortunately, that's all for now. Will you return as Detective Jack 'The Shadow' " +
                "Malone and solve the case of the missing coach.");
    }
}
