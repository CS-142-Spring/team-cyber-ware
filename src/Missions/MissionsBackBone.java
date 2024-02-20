package Missions;
import static Resources.DemoStory.demoEnd;

public class MissionsBackBone {

    public static void main(String[] args) {
    }

    static boolean uniqueItem1 = false; // represents that the Magnifying glass has not been found
    static boolean uniqueItem2 = false; // represents that the Notebook has not been found
    static boolean uniqueItem3 = false; // represents that the Trench Coat has not been found
    static boolean uniqueItem4 = false; // represents that the football year book has not been found
    static boolean uniqueItem5 = false; // represents that the janitor closet key has not been found
    static boolean uniqueItem6 = false; // represents that coach Marlowe's password hint has not been found
    static boolean uniqueEvidence1 = false; // represents that coach Marlowe's email has not been discovered.

    static boolean puzzle1 = false; // represents that puzzle has not been solved
    public static void missionOne() {
        // this mission requires players to just pick up Malone's personal items to handle the case he embarks on
        boolean stageOne = false;

        while (!stageOne) {
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
                System.out.println("All conditions are true1");
                missionTwo(); // Proceeds to the next stage.
            } else {
                // Implement game logic here to allow conditions to change based on player actions.
            }
        }
    }

    public static void setMissionOneBooleansTrue() {
        uniqueItem1 = true; // represents that the magnifying glass has been found
        uniqueItem2 = true; // represents that the Notebook has been found
        uniqueItem3 = true; // represents that the Trench Coat has been found
        missionOne();
    }


    public static void missionTwo() {
        // Players are looking for the coach at this point
        //
        boolean stageTwo = false;
        while (!stageTwo) {
            boolean[] conditions = {uniqueItem4, uniqueItem5, uniqueItem6, uniqueEvidence1};
            boolean allTrue = true;

            for (boolean condition : conditions) {
                if (!condition) { // if not, conditions are not true, this will break the loop because it's still false.
                    allTrue = false;
                    break; //  need to rewrite, so it doesn't just break, but also needs it so it's not an infinite loop in the background.
                }
            }

            if (allTrue) {
                stageTwo = true;
                System.out.println("All conditions are true2");
                demoEnd();
//                missionThree(); // Call the next stage here if needed.
            } else {
                System.out.println("All conditions are false2");
            }
        }
    }

    public static void setMissionTwoBooleansTrue() {
        uniqueItem4 = true; // represents that the football year book has not been found
        uniqueItem5 = true; // represents that the janitor closet key has not been found
        uniqueItem6 = true; // represents that coach Marlowe's password hint has not been found
        uniqueEvidence1 = true; // // represents that coach Marlowe's email has not been discovered.
        missionTwo();
    }

    public static void missionThree() {
        boolean stageThree = false;
        while (!stageThree) {
            boolean[] conditions = {};
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
                demoEnd(); // this will play the end screen for the sake of completing the midterm assignment.
            } else {
                System.out.println("All conditions are false3"); // This is for testing purposes, will not be in the game, remove later.
            }
        }
    }

    public static void setMissionThreeBooleansTrue() {
        puzzle1 = false;
        demoEnd(); // maybe plays demo end
    }
}